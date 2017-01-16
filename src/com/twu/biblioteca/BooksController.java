package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;

public class BooksController {

    private Scanner scanner;
    PrintStream printStream;

    private final Map<Integer, Book> books = new HashMap<>();
    private UserController userController;

    public BooksController(Scanner scanner, PrintStream printStream, UserController userController) {
        this.scanner = scanner;
        this.printStream = printStream;
        this.userController = userController;
        books.put(1, new Book("ABC", "Simon", 2017, 1, false));
        books.put(2, new Book("DEF", "Nana", 2017, 2, false));
    }

    public List<Book> listAvailableBooks() {
        List<Book> books = new ArrayList<>();
        for (Book book : this.books.values()) {
            if (!book.isCheckedOut()) {
                books.add(book);
            }
        }
        return books;
    }

    public void getAllBooksWithDetails() {
        StringBuffer buffer = new StringBuffer();
        for (Book book : listAvailableBooks()) {
            buffer.append(book.getId());
            buffer.append(" | ");
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
        Book book = books.get(bookID);

        if (book.isCheckedOut()) {
            printStream.println("That book is not available.");
        } else {
            book.setCheckedOut(true);
            printStream.println("Thank you! Enjoy the book.");
        }
    }

    public void returnBook(int bookID) {
        Book book = books.get(bookID);
        if (book.isCheckedOut()) {
            book.setCheckedOut(false);
            printStream.println("Thank You for returning the book.");
        } else {
            printStream.println("That is not a valid book to return.");
        }
    }

    public void handleCheckoutBook() {
        userController.doLogIn();
        printStream.println("Which book id do you want to checkout?");
        checkoutBook(scanner.nextInt());
    }

}
