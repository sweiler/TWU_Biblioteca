package com.twu.biblioteca;

import lombok.AllArgsConstructor;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoviesController {

    private PrintStream printStream;

    private final Map<Integer, Movie> movies = new HashMap<>();

    public MoviesController(PrintStream printStream) {
        this.printStream = printStream;
        movies.put(1, new Movie("Star Wars", 1977, "George Lucas", MovieRating.unrated()));
        movies.put(2, new Movie("Inception", 2010, "Christopher Nolan", MovieRating.ratedAs(8.8)));
    }

    public List<Movie> listAvailableMovies() {
        List<Movie> movies = new ArrayList<>();
        for (Movie movie : this.movies.values()) {
            if (!movie.isCheckedOut()) {
                movies.add(movie);
            }
        }

        return movies;
    }

    public void getAllMoviesWithDetails() {
        StringBuffer buffer = new StringBuffer();
        for (Movie movie : movies.values()) {
            buffer.append(movie.getId());
            buffer.append(" | ");
            buffer.append(movie.getMovieName());
            buffer.append(" | ");
            buffer.append(movie.getYear());
            buffer.append(" | ");
            buffer.append(movie.getDirectorName());
            buffer.append(" | ");
            buffer.append(movie.getMovieRating());
            buffer.append("\n");
        }
        printStream.print(buffer.toString());
    }

    public void checkoutMovie(int movieId) {
        Movie movie = movies.get(movieId);

        if (movie.isCheckedOut()) {
            printStream.println("That movie is not available.");
        } else {
            movie.setCheckedOut(true);
            printStream.println("Thank you! Enjoy the movie.");
        }
    }
}
