package com.yazlab21.webIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.yazlab21.entity.FrequencyWrapper;
import com.yazlab21.entity.WordFrequency;

public class FindFrequency {

    public static FrequencyWrapper getFrequency(String urlText, String baseUrl) {

        FrequencyWrapper wrapper = new FrequencyWrapper();

        String url1 = urlText;
        String url = url1.toLowerCase();
        String[] urlWords = url.split("\\s");
        List<String> als = new ArrayList<String>();
        als = Arrays.asList(urlWords);
        Collections.sort(als);

        List<WordFrequency> frequencies = new ArrayList<>();
        List<String> words = new ArrayList<>();
        WordFrequency temp = new WordFrequency();

        for (String al : als) {
            if (!words.contains(al)) {
                words.add(al);
                temp.setWord(al);
                temp.setCount(Collections.frequency(als, al));
                frequencies.add(temp);
                temp = new WordFrequency();
            }
        }
        frequencies.sort(Comparator.comparing(WordFrequency::getCount));

        List<WordFrequency> keyWords = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            if (frequencies.size() - 1 - i >= 0)
                keyWords.add(frequencies.get(frequencies.size() - 1 - i));
        }

        wrapper.setWordFrequency(frequencies);
        wrapper.setWords(words);
        wrapper.setKeyWords(keyWords);
        wrapper.setSize(als.size());
        wrapper.setUrl(baseUrl);
        return wrapper;
    }
    public static FrequencyWrapper getFrequency(String urlText) {

        FrequencyWrapper wrapper = new FrequencyWrapper();

        String url1 = urlText;
        String url = url1.toLowerCase();
        String[] urlWords = url.split("\\s");
        List<String> als = new ArrayList<String>();
        als = Arrays.asList(urlWords);
        Collections.sort(als);

        List<WordFrequency> frequencies = new ArrayList<>();
        List<String> words = new ArrayList<>();
        WordFrequency temp = new WordFrequency();

        for (String al : als) {
            if (!words.contains(al)) {
                words.add(al);
                temp.setWord(al);
                temp.setCount(Collections.frequency(als, al));
                frequencies.add(temp);
                temp = new WordFrequency();
            }
        }
        frequencies.sort(Comparator.comparing(WordFrequency::getCount));
        Collections.reverse(frequencies);
        List<WordFrequency> keyWords = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            if (frequencies.size() - 1 - i >= 0)
                keyWords.add(frequencies.get(frequencies.size() - 1 - i));
        }

        wrapper.setWordFrequency(frequencies);
        wrapper.setWords(words);
        wrapper.setKeyWords(keyWords);
        wrapper.setSize(als.size());
        return wrapper;
    }
}
