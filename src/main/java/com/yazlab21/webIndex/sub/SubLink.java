package com.yazlab21.webIndex.sub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SubLink {

    public List<String> getSubLinks(String url) throws IOException {
        Document doc;

        doc = Jsoup.connect(url).get();
        Elements elements = doc.select("a");
        List<String> subLinks = new ArrayList<String>();

        for (Element element : elements) {
            if (element.attr("href").startsWith("http"))
            subLinks.add(element.attr("href"));


        }
        return subLinks;

    }
}



