package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BooksControllerTest {

    private BooksController booksController;
    private AdvancedPrintStream advancedPrintStream;

    @Before
    public void setUp(){
        advancedPrintStream = new AdvancedPrintStream();
        booksController = new BooksController(new Scanner(System.in), advancedPrintStream.getPrintStream());
    }

    @Test
    public void shouldGetListOfAvailableBooks(){
        assertThat(booksController.listAvailableBooks(),is(Arrays.asList(
                new Book("ABC", "Simon", 2017,1,false),
                new Book("DEF","Nana",2017,2,false))));
    }

    @Test
    public void shouldCheckoutABook() {
        booksController.checkoutBook(1);
        assertThat(booksController.listAvailableBooks(),is(Arrays.asList(new Book("DEF","Nana",2017,2,false))));
    }

    @Test
    public void shouldPrintSuccessfulCheckoutMessageForCheckoutABook() {
        booksController.checkoutBook(1);
        assertThat(advancedPrintStream.getContents(), containsString("Thank you! Enjoy the book.\n"));
    }

    @Test
    public void shouldPrintUnsuccessfulCheckoutMessageForCheckoutABook() {
        booksController.checkoutBook(1);
        booksController.checkoutBook(1);
        assertThat(advancedPrintStream.getContents(), containsString("That book is not available.\n"));
    }

    @Test
    public void shouldReturnABook() {
        booksController.checkoutBook(1);
        booksController.returnBook(1);
        assertThat(booksController.listAvailableBooks(),is(Arrays.asList(new Book("ABC", "Simon", 2017,1,false),
                new Book("DEF","Nana",2017,2,false))));
    }

    @Test
    public void shouldPrintSuccessfulMessageOnReturningABook() {
        booksController.checkoutBook(1);
        booksController.returnBook(1);
        assertThat(advancedPrintStream.getContents(), containsString("Thank You for returning the book.\n"));
    }

    @Test
    public void shouldPrintUnSuccessfulMessageOnReturningABook() {
        booksController.checkoutBook(1);
        booksController.returnBook(2);
        assertThat(advancedPrintStream.getContents(), containsString("That is not a valid book to return.\n"));
    }

}
