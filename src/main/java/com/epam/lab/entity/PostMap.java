package com.epam.lab.entity;


import com.epam.lab.validator.ValidResponse;

import java.util.LinkedList;
import java.util.List;

public class PostMap {
    private List<String> names = new LinkedList<>();
    private List<ValidResponse> validArray = new LinkedList<>();

    private String minDate;
    private String maxDate;

    public PostMap(List<ValidResponse> validParams, List<String> resNames, String maxRes, String minRes) {
        this.minDate = minRes;
        this.maxDate = maxRes;
        this.names = resNames;
        this.validArray = validParams;
    }
    public List<ValidResponse> getValidArray() { return validArray; }
    public void setNames(List<String> names) { this.names = names;  }
    public List<String> getNames() { return names; }
    public String getMaxDate() { return maxDate; }
    public String getMinDate() { return minDate; }
    public void setMaxDate(String maxDate) { this.maxDate = maxDate; }
    public void setMinDate(String minDate) { this.minDate = minDate; }
    public void setValidArray(List<ValidResponse> validArray) { this.validArray = validArray; }
}
