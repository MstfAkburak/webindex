package com.yazlab21.webIndex.sub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.yazlab21.entity.FrequencyWrapper;
import com.yazlab21.webIndex.FindFrequency;
import com.yazlab21.webIndex.UrlConvertToString;

public class CalculateIndex {

    public static List<FrequencyWrapper> calculate(String url) throws IOException {
        SubLink sub = new SubLink();
        List<String> linkList = sub.getSubLinks(url);
        List<FrequencyWrapper> results = new ArrayList<>();

        for (String s : linkList) {

            results.add(FindFrequency.getFrequency(UrlConvertToString.getUrlWords(s),s));
        }

        return results;
    }

}
