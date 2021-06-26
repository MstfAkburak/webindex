package com.yazlab21.form;

import com.yazlab21.entity.FrequencyWrapper;

import java.util.List;

public class SubComparisonForm {
    private FrequencyWrapper wrappers;
    private Integer scores;

    public FrequencyWrapper getWrappers() {
        return wrappers;
    }

    public void setWrappers(FrequencyWrapper wrappers) {
        this.wrappers = wrappers;
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }
}
