package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BooksControllerTest {

    private BooksController booksController;
    private AdvancedPrintStream advancedPrintStream;

    @Before
    public void setUp(){
        advancedPrintStream = new AdvancedPrintStream();
        booksController = new BooksController(advancedPrintStream.getPrintStream());
    }

    @Test
    public void shouldGetListOfBooks(){
        assertThat(booksController.listBooks(),is(Arrays.asList(new Book("ABC", "Simon", 2017), new Book("DEF","Nana",2017))));
    }
}
