package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    private Library library;

    @Before
    public void setUp(){
        library = new Library();
    }

    @Test
    public void shouldGetListOfBooks(){
        assertThat(library.listBooks(),is(Arrays.asList(new Book("ABC"), new Book("DEF"))));
    }

    @Test
    public void shouldReturnAllBookTitles() {
        assertThat(library.getAllBookTitles(), is("ABC, DEF"));
    }
}
