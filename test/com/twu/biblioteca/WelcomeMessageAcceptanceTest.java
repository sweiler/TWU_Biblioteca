package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertEquals;

public class WelcomeMessageAcceptanceTest {

    private AdvancedPrintStream advancedPrintStream;
    private BibliotecaApp app;

    @Before
    public void setUp() {
        advancedPrintStream = new AdvancedPrintStream();
        app = new BibliotecaApp(advancedPrintStream.getPrintStream());
    }

    @Test
    public void shouldDisplayAWelcomeMessage() {
        app.run();
        assertThat(advancedPrintStream.getContents(), containsString("Biblioteca"));
    }
}
