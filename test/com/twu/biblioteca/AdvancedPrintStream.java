package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class AdvancedPrintStream {
    private final ByteArrayOutputStream byteArrayOutputStream;
    private final PrintStream printStream;

    public AdvancedPrintStream() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(byteArrayOutputStream);
    }

    public PrintStream getPrintStream() {
        return printStream;
    }

    public String getContents() {
        return new String(byteArrayOutputStream.toByteArray(), StandardCharsets.UTF_8);
    }
}
