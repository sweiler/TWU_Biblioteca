package com.twu.biblioteca;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class MovieRating {

    @Getter
    private double rating;

    @Getter
    private boolean rated;

    private MovieRating(double rating, boolean rated) {
        this.rating = rating;
        this.rated = rated;
    }

    public static MovieRating unrated() {
        return new MovieRating(0, false);
    }

    public static MovieRating ratedAs(double rating) {
        return new MovieRating(rating, true);
    }
}
