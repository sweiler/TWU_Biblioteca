package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class UserAccountsTest {

    private UserController userController;

    @Before
    public void setUp() {
        userController = new UserController(new Scanner(System.in), System.out);
    }

    @Test
    public void userLogin() {
        assertThat(userController.userLogin("123-4567", "secret"), is(notNullValue()));
    }

    @Test
    public void userLoginFail() {
        assertThat(userController.userLogin("123-4567", "secret1"), is(nullValue()));
    }




}
