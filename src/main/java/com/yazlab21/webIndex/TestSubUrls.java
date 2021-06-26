package com.yazlab21.webIndex;

import com.yazlab21.entity.FrequencyWrapper;
import com.yazlab21.webIndex.sub.CalculateIndex;
import com.yazlab21.webIndex.sub.ScoreSubUrls;

import java.io.IOException;
import java.util.List;

public class TestSubUrls {
    public static void main(String[] args) throws IOException {
        CalculateIndex calculateIndex = new CalculateIndex();
        List<FrequencyWrapper> wrappers = calculateIndex.calculate("https://learntodroid.com/how-to-create-a-simple-alarm-clock-app-in-android/");
        String url1 = UrlConvertToString.getUrlWords("https://learntodroid.com/how-to-create-a-simple-alarm-clock-app-in-android/");

        ScoreSubUrls scoreSubUrls = new ScoreSubUrls();

        System.out.println(scoreSubUrls.getScores(FindFrequency.getFrequency(url1, "").getWordFrequency(), wrappers).toString());

    }
}
