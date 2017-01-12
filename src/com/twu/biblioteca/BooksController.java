package com.twu.biblioteca;

import lombok.AllArgsConstructor;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class BooksController {

    PrintStream printStream;

    private static final List<Book> BOOKS = Arrays.asList(
            new Book("ABC", "Simon", 2017), new Book("DEF","Nana",2017));

    public List<Book> listBooks() {
        return BOOKS;
    }

    public void getAllBooksWithDetails() {
        StringBuffer buffer = new StringBuffer();
        for (Book book: BOOKS) {
            buffer.append(book.getTitle());
            buffer.append(" | ");
            buffer.append(book.getAuthor());
            buffer.append(" | ");
            buffer.append(book.getYear());
            buffer.append("\n");
        }
        printStream.print(buffer.toString());
    }
}
