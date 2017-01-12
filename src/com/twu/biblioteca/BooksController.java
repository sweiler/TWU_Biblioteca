package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BooksController {

    PrintStream printStream;

    private final Map<Integer,Book> books = new HashMap<>();

    public BooksController(PrintStream printStream) {
        this.printStream = printStream;
        books.put(1,new Book("ABC", "Simon", 2017,1,false));
        books.put(2,new Book("DEF", "Nana", 2017,2,false));
    }

    public List<Book> listAvailableBooks() {
        List<Book> books = new ArrayList<>();
        for (Book book: this.books.values()) {
            if(!book.isCheckedOut()) {
                books.add(book);
            }
        }
        return books;
    }

    public void getAllBooksWithDetails() {
        StringBuffer buffer = new StringBuffer();
        for (Book book: books.values()) {
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
         books.get(bookID).setCheckedOut(true);

    }
}
