package com.twu.biblioteca.matchers;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ContainsStringNTimesMatcherTest {
    @Test
    public void shouldMatchAStringWithCountAppearancesOfSubstring() {
        String testString = "ABC\nBCA\nABC";
        ContainsStringNTimesMatcher matcher = new ContainsStringNTimesMatcher("ABC", 2);
        assertThat(matcher.matchesSafely(testString), is(true));
    }

    @Test
    public void shouldNotMatchAStringWithLessAppearances() {
        String testString = "ABC\nBCA";
        ContainsStringNTimesMatcher matcher = new ContainsStringNTimesMatcher("ABC", 2);
        assertThat(matcher.matchesSafely(testString), is(false));
    }

}