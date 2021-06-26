package com.yazlab21.webIndex;

import com.yazlab21.entity.FrequencyWrapper;
import com.yazlab21.entity.WordFrequency;

import java.util.List;

public class UrlScoring {
    public static int getScore(List<WordFrequency> keyWords, List<WordFrequency> wordFrequencies, int size) {
        // keywords;    1 2 3 4 5
        // 2. keywords; 1 2 3 4 5
        int score = 0;
        if (size == 0) {
            return 0;
        } else {
            for (WordFrequency wordFrequency : keyWords) {
                for (WordFrequency word : wordFrequencies) {
                    if (wordFrequency.getWord().equals(word.getWord())) {
                        score += 20;
                    }
                }
            }

        }
        return score;

    }


}

