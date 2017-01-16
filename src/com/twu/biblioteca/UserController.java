package com.twu.biblioteca;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserController {

    private final Map<String, User> users = new HashMap<>();
    private Scanner scanner;
    private PrintStream printStream;
    private User loggedInUser = null;

    public UserController(Scanner scanner, PrintStream printStream) {
        this.printStream = printStream;
        this.scanner = scanner;
        users.put("123-4567", new User("123-4567", "secret"));
        users.put("123-1234", new User("123-1234", "pass"));
    }

    public User userLogin(String libraryNumber, String password) {
        User user = users.get(libraryNumber);
        if (user == null) {
            return null;
        }
        return user.getPassword().equals(password) ? user : null;
    }

    public boolean isUserLoggedIn() {
        return loggedInUser != null;
    }

    public void doLogIn() {
        if (!isUserLoggedIn()) {
            printStream.println("Please login.");
            printStream.println("Library Number:");
            String libraryNumber = scanner.next();
            printStream.println("Password");
            String password = scanner.next();

            User user = userLogin(libraryNumber, password);
            if (user != null) {
                loggedInUser = user;
            } else {
                doLogIn();
            }
        }
    }
}
