package com.yazlab21.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.yazlab21.entity.FrequencyWrapper;
import com.yazlab21.entity.WordFrequency;
import com.yazlab21.form.SingleFrekansForm;
import com.yazlab21.form.SubComparisonForm;
import com.yazlab21.webIndex.FindFrequency;
import com.yazlab21.webIndex.UrlConvertToString;
import com.yazlab21.webIndex.UrlScoring;
import com.yazlab21.webIndex.sub.CalculateIndex;
import com.yazlab21.webIndex.sub.ScoreSubUrls;
import com.yazlab21.webIndex.sub.SubLink;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller

public class FirstController {

    @GetMapping("/")
    public String homepage() {
        return "homepage";
    }

    @GetMapping("/frekans")
    public String frequence(Model theModel) {
        theModel.addAttribute("urls", new SingleFrekansForm());
        return "single-score";
    }

    @RequestMapping(value = "/calculate-single", method = RequestMethod.POST)
    public String calculateSingle(@ModelAttribute("urls") SingleFrekansForm urls, Model theModel) {
        List<WordFrequency> frequencies = FindFrequency.getFrequency(UrlConvertToString.getUrlWords(urls.getSourceUrl())).getWordFrequency();
        theModel.addAttribute("freq", frequencies);
        theModel.addAttribute("baseUrl", urls.getSourceUrl());
        return "single-result";
    }

    @GetMapping("/keyword")
    public String singleKeyword(Model theModel) {
        theModel.addAttribute("urls", new SingleFrekansForm());
        return "single-keywords";
    }

    @RequestMapping(value = "/calculate-single-keywords", method = RequestMethod.POST)
    public String calculateKeywords(@ModelAttribute("urls") SingleFrekansForm urls, Model theModel) {
        List<WordFrequency> frequencies = FindFrequency.getFrequency(UrlConvertToString.getUrlWords(urls.getSourceUrl()), "").getKeyWords();
        theModel.addAttribute("freq", frequencies);
        theModel.addAttribute("baseUrl", urls.getSourceUrl());
        return "single-keywords-result";
    }

    @GetMapping("/dual-comparison")
    public String dualComparison(Model theModel) {
        theModel.addAttribute("urls", new SingleFrekansForm());
        return "dual-comparison";
    }

    @RequestMapping(value = "/dual-comparison-calculate", method = RequestMethod.POST)
    public String dualComparisonCalculate(@ModelAttribute("urls") SingleFrekansForm urls, Model theModel) {
        List<WordFrequency> frequencies = FindFrequency.getFrequency(UrlConvertToString.getUrlWords(urls.getSourceUrl()), "").getKeyWords();
        List<WordFrequency> frequencies2 = FindFrequency.getFrequency(UrlConvertToString.getUrlWords(urls.getTargetUrl()), "").getKeyWords();
        double score = UrlScoring.getScore(frequencies, frequencies2, frequencies2.size());
        theModel.addAttribute("freq1", urls.getSourceUrl());
        theModel.addAttribute("freq2", urls.getTargetUrl());
        theModel.addAttribute("score", score);
        return "dual-comparison-result";
    }

    @GetMapping("/sub-comparison")
    public String subComparison(Model theModel) {
        theModel.addAttribute("urls", new SingleFrekansForm());
        return "sub-comparison";
    }

    @RequestMapping(value = "/sub-comparison-calculate", method = RequestMethod.POST)
    public String subComparisonCalculate(@ModelAttribute("urls") SingleFrekansForm urls, Model theModel) {
        List<WordFrequency> frequencies = FindFrequency.getFrequency(UrlConvertToString.getUrlWords(urls.getSourceUrl()), "").getKeyWords();
        List<FrequencyWrapper> wrappers;
        List<Integer> scores;
        try {
            wrappers = CalculateIndex.calculate(urls.getSourceUrl());
            scores = ScoreSubUrls.getScores(frequencies, wrappers);
        } catch (Exception e) {
            wrappers = new ArrayList<>();
            scores = new ArrayList<>();
        }
        List<SubComparisonForm> form = new ArrayList<>();
        SubComparisonForm form1;
        for (int i = 0; i < wrappers.size(); i++) {
            form1 = new SubComparisonForm();
            form1.setScores(scores.get(i));
            form1.setWrappers(wrappers.get(i));
            form.add(form1);
        }

        theModel.addAttribute("baseUrl", urls.getSourceUrl());
        theModel.addAttribute("forms", form);
        return "sub-comparison-result";
    }

}
