package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainMenuTest {

    private Runnable emptyRunnable = new Runnable() {
        @Override
        public void run() {

        }
    };

    private class RecordingRunnable implements Runnable {
        private boolean called = false;

        @Override
        public void run() {
            called = true;
        }
    }

    private MainMenu mainMenu;
    private AdvancedPrintStream advancedPrintStream;

    @Before
    public void setUp() {
        advancedPrintStream = new AdvancedPrintStream();
        simulateInput("0\n");
    }

    @Test
    public void shouldListOptions() {
        mainMenu.addOption("Option A", emptyRunnable);
        mainMenu.addOption("Option B", emptyRunnable);

        mainMenu.runMainMenu();

        assertThat(advancedPrintStream.getContents(), is("0: Option A\n1: Option B\n"));

    }

    @Test
    public void shouldExecuteOptionsBasedOnUsersInput() {
        simulateInput("2\n0\n");

        RecordingRunnable recordingRunnable1 = new RecordingRunnable();
        RecordingRunnable recordingRunnable2 = new RecordingRunnable();

        mainMenu.addOption("Option A", emptyRunnable);
        mainMenu.addOption("Option B", recordingRunnable1);
        mainMenu.addOption("Option C", recordingRunnable2);

        mainMenu.runMainMenu();

        assertThat(recordingRunnable1.called, is(false));
        assertThat(recordingRunnable2.called, is(true));
    }

    private void simulateInput(String input) {
        mainMenu = new MainMenu(
                new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)),
                advancedPrintStream.getPrintStream());
    }

}
