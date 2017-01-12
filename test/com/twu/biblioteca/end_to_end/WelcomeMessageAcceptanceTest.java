package com.twu.biblioteca.end_to_end;


import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class WelcomeMessageAcceptanceTest extends BaseAcceptanceTest {

    @Test
    public void shouldDisplayAWelcomeMessage() {
        app.run();
        assertThat(advancedPrintStream.getContents(), containsString("Biblioteca"));
    }

    @Before
    public void setUp() {
        baseSetUp();
    }
}
