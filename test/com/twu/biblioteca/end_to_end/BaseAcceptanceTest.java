package com.twu.biblioteca.end_to_end;

import com.twu.biblioteca.AdvancedPrintStream;
import com.twu.biblioteca.BibliotecaApp;
import org.junit.Before;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public abstract class BaseAcceptanceTest {
    protected AdvancedPrintStream advancedPrintStream;
    protected BibliotecaApp app;

    protected void baseSetUp() {
        advancedPrintStream = new AdvancedPrintStream();
        app = new BibliotecaApp(System.in, advancedPrintStream.getPrintStream());
        provideInput("0\n");
    }

    protected void provideInput(String exampleInput) {
        InputStream exampleInputStream = new ByteArrayInputStream(exampleInput.getBytes(StandardCharsets.UTF_8));
        app = new BibliotecaApp(exampleInputStream, advancedPrintStream.getPrintStream());
    }
}
