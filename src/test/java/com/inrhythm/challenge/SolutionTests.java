package com.inrhythm.challenge;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class SolutionTests {
    private Solution solution = null;

    @Before
    public void before() {
        solution = new Solution();
    }

    @Test
    public void testExampleFromChallenge() {
        final String s = "The cow jumped over the moon.";
        final Map<Integer, List<String>> exp = new HashMap();
        exp.put(6, Collections.singletonList("jumped"));
        assertThat(solution.getLenAndLongestWords(s), is(exp));

    }

    @Test
    public void testMultipleList() {
        final String s = "he me to we I";
        final Map<Integer, List<String>> exp = new HashMap();
        exp.put(2, Arrays.asList("he me to we".split(" ")));
        assertThat(solution.getLenAndLongestWords(s), is(exp));
    }

    @Test
    public void testMultipleListSameSizeWords() {
        final String s = "he me to we";
        final Map<Integer, List<String>> exp = new HashMap();
        exp.put(2, Arrays.asList(s.split(" ")));
        assertThat(solution.getLenAndLongestWords(s), is(exp));
    }

    @Test
    public void testEmpty() {
        final String s = "";
        final Map<Integer, List<String>> exp = new HashMap();
        exp.put(0, Collections.singletonList(""));
        assertThat(solution.getLenAndLongestWords(s), is(exp));
    }

    @Test(expected = RuntimeException.class)
    public void testNull() {
        solution.getLenAndLongestWords(null);
    }

    @Test
    public void testOneChar() {
        final String s = "z";
        final Map<Integer, List<String>> exp = new HashMap();
        exp.put(1, Collections.singletonList("z"));
        assertThat(solution.getLenAndLongestWords(s), is(exp));
    }


    @Test
    public void testNoSpace() {
        final String s = "nospacez";
        final Map<Integer, List<String>> exp = new HashMap();
        exp.put(8, Collections.singletonList("nospacez"));
        assertThat(solution.getLenAndLongestWords(s), is(exp));
    }


    @Test(expected = RuntimeException.class)
    public void testSpacesOnly() {
        final String s = "                                   ";
        solution.getLenAndLongestWords(s);
    }

    @Test
    public void testDotsAreIgnored() {
        final String s = ".hi. a... b!... c??";
        final Map<Integer, List<String>> exp = new HashMap();
        exp.put(2, Collections.singletonList("hi"));
        assertThat(solution.getLenAndLongestWords(s), is(exp));
    }

    @Test
    public void testSpecCharsAreIgnored() {
        final String s = ".hi.(*&#&*#@@#*((!)@       hey you &^*&(*^ ' ' ' ?~#((*^#@(&)*    (&#^@&^@#L:*^#@#@#";
        final Map<Integer, List<String>> exp = new HashMap();
        exp.put(3, Arrays.asList("hey", "you"));
        assertThat(solution.getLenAndLongestWords(s), is(exp));
    }
}
