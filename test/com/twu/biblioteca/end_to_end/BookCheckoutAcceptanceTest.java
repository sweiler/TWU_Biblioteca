package com.twu.biblioteca.end_to_end;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class BookCheckoutAcceptanceTest extends BaseAcceptanceTest {

    @Before
    public void setUp() {
        baseSetUp();
    }

    @Test
    public void shouldAllowCheckoutOfBooks() {
        provideInput("3\n123-4567\nsecret\n1\n1\n0\n");

        app.run();

        assertThat(advancedPrintStream.getContents(), containsString("Please login."));
        assertThat(advancedPrintStream.getContents(), containsString("Which book id do you want to checkout?"));
        assertThat(advancedPrintStream.getContents(), containsString("Thank you! Enjoy the book."));
        assertThat(advancedPrintStream.getContents(), not(containsString("1 | ABC | Simon | 2017")));
    }
}
