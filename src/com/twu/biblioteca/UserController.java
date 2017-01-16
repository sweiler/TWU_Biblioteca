package com.twu.biblioteca;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {

    private final Map<String, User> users = new HashMap<>();

    public UserController() {
        users.put("123-4567", new User("123-4567","secret"));
        users.put("123-1234", new User("123-1234", "pass"));
    }

    public boolean userLogin(String libraryNumber, String password) {
        User user = users.get(libraryNumber);
        return user.getPassword().equals(password);

    }
}
