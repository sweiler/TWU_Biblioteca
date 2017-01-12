package com.twu.biblioteca;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
public class MainMenu {

    private InputStream inputStream;
    private PrintStream printStream;
    private List<MainMenuOption> mainMenuOptions = new ArrayList<>();
    private Scanner scanner;


    public MainMenu(InputStream inputStream, PrintStream printStream) {

        this.inputStream = inputStream;
        this.printStream = printStream;
        scanner = new Scanner(this.inputStream);
    }

    public void addOption(String name, Runnable runnable) {
        mainMenuOptions.add(new MainMenuOption(name, runnable));
    }

    public void runMainMenu() {
        int userInput;
        do {
            printOptionsMenu();
            userInput = getUserInput();
            runSelectedOption(userInput);
        } while (userInput != 0);

    }

    private void runSelectedOption(int userInput) {
        if (userInputIsInRange(userInput)) {
            mainMenuOptions.get(userInput).runnable.run();
        } else {
            printStream.println("Select a valid option.");
        }
    }

    private boolean userInputIsInRange(int userInput) {
        return (userInput < mainMenuOptions.size() && userInput >= 0);
    }

    private void printOptionsMenu() {
        for (int i = 0; i < mainMenuOptions.size(); i++) {
            printStream.println(i + ": " + mainMenuOptions.get(i).optionName);
        }
    }

    private int getUserInput() {
        return scanner.nextInt();
    }

    @AllArgsConstructor
    private class MainMenuOption {
        String optionName;
        Runnable runnable;
    }
}
