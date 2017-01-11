package com.twu.biblioteca;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
public class Book {

    @Getter
    private String title;

    public Book() {

    }

    public Book(String title) {
        this.title = title;
    }


}
