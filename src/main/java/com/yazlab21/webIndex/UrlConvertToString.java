package com.yazlab21.webIndex;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class UrlConvertToString {
    public static String getUrlWords(String url) {

        try {
            Document doc = Jsoup.connect(url).get();
            return doc.text();
        } catch (Exception e) {
            return "";
        }

    }

}
