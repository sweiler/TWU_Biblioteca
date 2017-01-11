package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class Library {

    private static final List<Book> BOOKS = Arrays.asList(
            new Book("ABC"), new Book("DEF"));



    public List<Book> listBooks() {
        return BOOKS;
    }

    public String getAllBookTitles() {
        StringBuffer buffer = new StringBuffer();
        for (Book book: BOOKS) {
            buffer.append(book.getTitle());
            buffer.append(", ");
        }

        return buffer.substring(0, buffer.length() - 2);
    }
}
