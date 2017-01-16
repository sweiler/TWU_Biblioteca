package com.twu.biblioteca;

import lombok.*;

@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Movie {

    @Getter @NonNull
    private String movieName;

    @Getter @NonNull
    private int year;

    @Getter @NonNull
    private String directorName;

    @Getter @NonNull
    private MovieRating movieRating;

    @Getter @Setter
    private boolean checkedOut = false;
}
