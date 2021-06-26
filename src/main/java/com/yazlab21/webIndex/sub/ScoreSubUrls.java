package com.yazlab21.webIndex.sub;

import com.yazlab21.entity.FrequencyWrapper;
import com.yazlab21.entity.WordFrequency;
import com.yazlab21.webIndex.UrlScoring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScoreSubUrls {
    public static List<Integer> getScores(List<WordFrequency> baseFrequency, List<FrequencyWrapper> sub) throws IOException {
        List<Integer> results = new ArrayList<>();
        for (FrequencyWrapper wrapper : sub) {
            results.add(UrlScoring.getScore(baseFrequency, wrapper.getWordFrequency(), wrapper.getSize()));
        }


        return results;
    }
}
