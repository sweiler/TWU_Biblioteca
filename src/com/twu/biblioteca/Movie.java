package com.twu.biblioteca;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Movie {

    @Getter
    private String movieName;

    @Getter
    private int year;

    @Getter
    private String directorName;

    @Getter
    private MovieRating movieRating;
}
