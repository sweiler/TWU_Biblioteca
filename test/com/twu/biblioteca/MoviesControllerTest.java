package com.twu.biblioteca;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MoviesControllerTest {

    private MoviesController moviesController;
    private AdvancedPrintStream advancedPrintStream;

    @Before
    public void setUp() {
        advancedPrintStream = new AdvancedPrintStream();
        moviesController = new MoviesController(advancedPrintStream.getPrintStream());
    }

    @Test
    public void shouldListAvailableMovies() {
        assertThat(moviesController.listAvailableMovies(), is(Arrays.asList(
            new Movie("Star Wars", 1977, "George Lucas", MovieRating.unrated()),
            new Movie("Inception", 2010, "Christopher Nolan", MovieRating.ratedAs(8.8))
        )));
    }
}
