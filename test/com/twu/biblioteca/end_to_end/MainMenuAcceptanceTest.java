package com.twu.biblioteca.end_to_end;

import com.twu.biblioteca.matchers.ContainsStringNTimesMatcher;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import static com.twu.biblioteca.matchers.ContainsStringNTimesMatcher.containsStringNTimes;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainMenuAcceptanceTest extends BaseAcceptanceTest {

    @Before
    public void setUp() {
        baseSetUp();
    }

    @Test
    public void shouldShowMainMenuOptions() {
        app.run();
        assertThat(advancedPrintStream.getContents(), containsString("1: List Books"));
    }

    @Test
    public void shouldPrintErrorMessageForInvalidOption() {
        provideInput("4\n0\n");
        app.run();
        assertThat(advancedPrintStream.getContents(), containsString("Select a valid option."));
    }

    @Test
    public void shouldProivdeQuitOption(){
        provideInput("0\n");
        app.run();
        assertThat(advancedPrintStream.getContents(),containsString("0: Quit"));
    }

    @Test
    public void shouldContinueIfNotChoosingQuit() {
        provideInput("1\n0\n");
        app.run();
        assertThat(advancedPrintStream.getContents(), containsStringNTimes("0: Quit", 2));
    }


}
