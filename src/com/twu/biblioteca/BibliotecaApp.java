package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BibliotecaApp {


    private InputStream inputStream;
    private final PrintStream printStream;

    public BibliotecaApp(InputStream inputStream, PrintStream printStream) {
        this.inputStream = inputStream;
        this.printStream = printStream;
    }

    public void run() {
        printStream.println("Welcome to Biblioteca");
        Scanner scanner = new Scanner(inputStream);
        MainMenu mainMenu = new MainMenu(scanner, printStream);
        final BooksController booksController = new BooksController(scanner, printStream);
        final MoviesController moviesController = new MoviesController(printStream);

        mainMenu.addOption("Quit", new Runnable() {
            @Override
            public void run() {

            }
        });

        mainMenu.addOption("List Book", new Runnable() {
            @Override
            public void run() {
                booksController.getAllBooksWithDetails();
            }
        });
        mainMenu.addOption("List Movies", new Runnable() {
            @Override
            public void run() {
                moviesController.getAllMoviesWithDetails();
            }
        });
        mainMenu.addOption("Checkout Book", new Runnable() {
            @Override
            public void run() {
                booksController.handleCheckoutBook();
            }
        });

        mainMenu.runMainMenu();

        scanner.close();
    }
}
