package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserAccountsTest {

    private UserController userController;

    @Before
    public void setUp() {
        userController = new UserController();
    }

    @Test
    public void userLogin() {
        assertThat(userController.userLogin("123-4567", "secret"), is(true));
    }

    @Test
    public void userLoginFail() {
        assertThat(userController.userLogin("123-4567", "secret1"), is(false));
    }



}
