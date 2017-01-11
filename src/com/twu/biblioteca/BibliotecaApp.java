package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {


    private final PrintStream printStream;

    public BibliotecaApp(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void run() {
        printStream.println("Welcome to Biblioteca");

        Library library = new Library();
        printStream.println(library.getAllBookTitles());
    }
}
