package com.twu.biblioteca.end_to_end;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class ListBooksAcceptanceTest extends BaseAcceptanceTest {

    @Before
    public void setUp() {
        baseSetUp();
    }

    @Test
    public void shouldListBooksWithDetailsInTheLibrary() {
        provideInput("1\n0\n");
        app.run();
        assertThat(advancedPrintStream.getContents(), containsString("1 | ABC | Simon | 2017\n2 | DEF | Nana | 2017\n"));
    }
}
