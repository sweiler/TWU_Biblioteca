package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BooksController {

    PrintStream printStream;

    private final Map<Integer, Movies> books = new HashMap<>();

    public BooksController(PrintStream printStream) {
        this.printStream = printStream;
        books.put(1, new Movies("ABC", "Simon", 2017, 1, false));
        books.put(2, new Movies("DEF", "Nana", 2017, 2, false));
    }

    public List<Movies> listAvailableBooks() {
        List<Movies> books = new ArrayList<>();
        for (Movies book : this.books.values()) {
            if (!book.isCheckedOut()) {
                books.add(book);
            }
        }
        return books;
    }

    public void getAllBooksWithDetails() {
        StringBuffer buffer = new StringBuffer();
        for (Movies book : books.values()) {
            buffer.append(book.getTitle());
            buffer.append(" | ");
            buffer.append(book.getAuthor());
            buffer.append(" | ");
            buffer.append(book.getYear());
            buffer.append("\n");
        }
        printStream.print(buffer.toString());
    }

    public void checkoutBook(int bookID) {
        Movies book = books.get(bookID);

        if (book.isCheckedOut()) {
            printStream.println("That book is not available.");
        } else {
            book.setCheckedOut(true);
            printStream.println("Thank you! Enjoy the book.");
        }
    }

    public void returnBook(int bookID) {
        Movies book = books.get(bookID);
        if (book.isCheckedOut()) {
            book.setCheckedOut(false);
            printStream.println("Thank You for returning the book.");
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }
}
