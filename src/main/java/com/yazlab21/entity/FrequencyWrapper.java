package com.yazlab21.entity;

import java.util.List;

public class FrequencyWrapper {

    private List<WordFrequency> wordFrequency;
    private List<String> words;
    private List<WordFrequency> keyWords;
    private int size;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<WordFrequency> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(List<WordFrequency> keyWords) {
        this.keyWords = keyWords;
    }

    public List<WordFrequency> getWordFrequency() {
        return wordFrequency;
    }

    public void setWordFrequency(List<WordFrequency> wordFrequency) {
        this.wordFrequency = wordFrequency;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "FrequencyWrapper{" +
                "wordFrequency=" + wordFrequency +
                ", words=" + words +
                ", keyWords=" + keyWords +
                ", size=" + size +
                ", url='" + url + '}';
    }
}
