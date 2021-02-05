package com.liuyanqing.power.matcher;

import com.liuyanqing.power.mockfinal.dao.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.ArgumentMatcher;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

/**
 * Created by liuyanqing on 2016/10/8.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void testFind() throws Exception {

        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);

        PowerMockito.when(userDao.queryByName("alex")).thenReturn("liuyanqing");
        UserService service = new UserService();
        String result = service.find("alex");
        assertEquals("liuyanqing", result);

        PowerMockito.when(userDao.queryByName("Jacky")).thenReturn("liuyanqing");
        String jacky = service.find("Jacky");
        assertEquals("liuyanqing", jacky);

        PowerMockito.when(userDao.queryByName("Tommy")).thenReturn("liuyanqing");
        String tommy = service.find("Tommy");
        assertEquals("liuyanqing", tommy);

    }

    @Test
    public void testFindWithMatcher() throws Exception {

        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);

        PowerMockito.when(userDao.queryByName(Matchers.argThat(new MyArgumentMatcher()))).thenReturn("liuyanqing");
        UserService service = new UserService();

        assertEquals("liuyanqing", service.find("Alex"));
        assertEquals("liuyanqing", service.find("Jacky"));
        assertEquals("liuyanqing", service.find("Van"));
        assertEquals("liuyanqing", service.find("Tony"));


    }

    @Test
    public void testFindWithAnswer() throws Exception {

        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);

        PowerMockito.when(userDao.queryByName(Mockito.anyString())).then(invocation -> {
            String arg = (String) invocation.getArguments()[0];
            switch (arg) {
                case "Jacky":
                    return "I am Jacky.";
                case "Alex":
                    return "I am Alex.";
                default:
                    throw new RuntimeException("Not support " + arg);

            }
        });

        UserService service = new UserService();

        assertEquals("I am Jacky.", service.find("Jacky"));
        assertEquals("I am Alex.", service.find("Alex"));

        try {
            String anyValue = service.find("AnyValue");
            fail("never process to here is right.");
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }
    }


    static class MyArgumentMatcher extends ArgumentMatcher<String> {

        @Override
        public boolean matches(Object o) {
            String arg = (String) o;
            switch (arg) {
                case "Alex":
                case "Jacky":
                case "Van":
                case "Tony":
                    return true;
                default:
                    return false;
            }
        }
    }
}