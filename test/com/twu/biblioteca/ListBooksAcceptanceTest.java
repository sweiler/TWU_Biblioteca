package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class ListBooksAcceptanceTest {

    private AdvancedPrintStream advancedPrintStream;
    private BibliotecaApp app;

    @Before
    public void setUp() {
        advancedPrintStream = new AdvancedPrintStream();
        app = new BibliotecaApp(advancedPrintStream.getPrintStream());
    }

    @Test
    public void shouldListBooksInTheLibrary() {
        app.run();
        assertThat(advancedPrintStream.getContents(), containsString("ABC, DEF"));
    }

}
