package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void userInformation(){
        User user = new User("123-4567", "secret", "Shahid", "something@twu.com", "1234567");
        assertThat(user.toString(),is("Library Number: 123-4567\n" +
                "User Name: Shahid\n" +
                "Email Address: something@twu.com\n" +
                "Phone Number: 1234567\n"));
    }

}
