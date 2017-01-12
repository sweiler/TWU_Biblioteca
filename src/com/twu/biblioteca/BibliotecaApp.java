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

        MainMenu mainMenu = new MainMenu(inputStream, printStream);
        final BooksController booksController = new BooksController(printStream);

        mainMenu.addOption("Quit", new Runnable() {
            @Override
            public void run() {

            }
        });

        mainMenu.addOption("List Books", new Runnable() {
            @Override
            public void run() {
                booksController.getAllBooksWithDetails();
            }
        });

        mainMenu.runMainMenu();
    }
}
