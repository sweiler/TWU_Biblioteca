package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BookTest {

    @Test
    public void shouldBeEqualWhenTitleIsTheSame() {
        Book a = new Book("AB");
        Book b = new Book("AB");

        assertThat(a, is(b));
    }

}
