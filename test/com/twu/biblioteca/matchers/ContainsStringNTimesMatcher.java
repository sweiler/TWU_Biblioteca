package com.twu.biblioteca.matchers;

import lombok.AllArgsConstructor;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

@AllArgsConstructor
public class ContainsStringNTimesMatcher extends TypeSafeMatcher<String> {

    private String substring;
    private int count;

    @Override
    protected boolean matchesSafely(String string) {
        return countAppearances(string) == count;
    }

    private int countAppearances(String string) {
        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = string.indexOf(substring, lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += substring.length();
            }
        }
        return count;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("containing ");
        description.appendValue(substring);
        description.appendText(" exactly ");
        description.appendValue(count);
        description.appendText(" times.");
    }


    public static Matcher<? super String> containsStringNTimes(String substring, int count) {
        return new ContainsStringNTimesMatcher(substring, count);
    }
}
