package com.twu.biblioteca;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class User {
    @Getter
    private String libraryNumber;

    @Getter
    private String password;

}
