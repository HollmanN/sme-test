package com.belatrix.smetest.domain;

public class WordClassification {
    private String word;
    private String wordCategory;

    public WordClassification(String word, String wordCategory) {
        this.word = word;
        this.wordCategory = wordCategory;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWordCategory() {
        return wordCategory;
    }

    public void setWordCategory(String wordCategory) {
        this.wordCategory = wordCategory;
    }

    @Override
    public String toString() {
        return
                "Word '" + word + '\'' + " represents a " + wordCategory;
    }

    public String[] asCSV() {
        return new String[]{word, wordCategory};
    }
}
