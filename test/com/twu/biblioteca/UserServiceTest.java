package com.twu.biblioteca;

import com.twu.biblioteca.exception.AccountNotExistExcepetion;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.repositories.UserRepository;
import com.twu.biblioteca.repositories.UserRepositoryImpl;
import com.twu.biblioteca.services.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        Mockito.when(userRepository.list()).thenReturn(  Arrays.asList(
                new User(1l,"Tom","010-8888",18,"123"),
                new User(2l,"Marry","010-9999",16,"123"),
                new User(3l,"Jack","010-6666",19,"123")
        ));
        userService = new UserService();
        userService.setUserRepository(userRepository);
    }

    @Test
    public void testUserLoginSuccessful() {
        Assert.assertTrue( userService.login("010-9999", "123") );
    }

    @Test
    public void testUserLoginWrongPassword() {
        Assert.assertTrue(!userService.login("010-8888", "124"));
    }

    @Test(expected = AccountNotExistExcepetion.class)
    public void testUserLoginAcountNotExist() {
        userService.login("101-777s7", "123");
    }
}
