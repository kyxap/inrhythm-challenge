package com.inrhythm.challenge;

import lombok.NonNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Solution {

    /**
     * Assumption: you can use any string but all non alphabet characters will be deleted from the sentence.
     *
     * @param sentence @NonNull String
     * @return length and longest words in a sentence
     */
    public Map<Integer, List<String>> getLenAndLongestWords(@NonNull final String sentence) {
        final Map.Entry<Integer, List<String>> rez;
        final String onlyLetters = sentence.replaceAll("[^A-Za-z\\s]", "");

        try {
            rez = Arrays.stream(onlyLetters.split("\\s+")).collect(Collectors.groupingBy(String::length))
                    .entrySet().stream().max(Map.Entry.comparingByKey()).get();
        } catch (final NoSuchElementException e) {
            throw new RuntimeException("Please use another string");
        }

        return new HashMap<Integer, List<String>>() {{
            put(rez.getKey(), rez.getValue());
        }};
    }

}
