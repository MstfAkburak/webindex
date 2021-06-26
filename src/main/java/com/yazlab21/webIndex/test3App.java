package com.yazlab21.webIndex;

import java.io.IOException;



public class test3App {
    public static void main(String[] args) throws IOException {
        String url1 = UrlConvertToString.getUrlWords("https://learntodroid.com/how-to-create-a-simple-alarm-clock-app-in-android/");
        String url2 = UrlConvertToString.getUrlWords("https://www.baeldung.com/learn-spring-course");


        // System.out.println(FindFrequency.getFrequency(url1).toString());
        //  System.out.println(FindFrequency.getFrequency(url2).toString());

        FindFrequency.getFrequency(url1,"").getKeyWords();
        FindFrequency.getFrequency(url2,"").getWordFrequency();

        System.out.println( UrlScoring.getScore(FindFrequency.getFrequency(url1,"").getKeyWords(),
                FindFrequency.getFrequency(url2,"").getWordFrequency(),FindFrequency.getFrequency(url2,"").getSize()));
    }
}
