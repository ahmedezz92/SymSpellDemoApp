package com.example.myapplication.symspell.apis;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Holds a pair of words.
 */
@RequiresApi(api = Build.VERSION_CODES.O)
public class Bigram {
    private final String word1;
    private final String word2;

    /**
     * Constructs a bigram with the specified words.
     *
     * @param word1 first word
     * @param word2 second word
     */
    public Bigram(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bigram)) return false;
        Bigram bigram = (Bigram) o;
        return Objects.equals(word1, bigram.word1) &&
                Objects.equals(word2, bigram.word2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word1, word2);
    }

    @Override
    public String toString() {
        return word1 + ' ' + word2;
    }
}