package com.epam.tc.hw7.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class MetalsInfo {

    @JsonProperty("summary")
    private List<String> summary;
    @JsonProperty("elements")
    private List<String> elements;
    @JsonProperty("metals")
    private String metals;
    @JsonProperty("color")
    private String color;

    @JsonProperty("vegetables")
    private List<String> vegetables;

    public List<String> getSummary() {
        return summary;
    }

    public List<String> getElements() {
        return elements;
    }

    public String getMetals() {
        return metals;
    }

    public String getColor() {
        return color;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public MetalsInfo() {
    }

    public MetalsInfo(List<String> summary, List<String> elements,
                      String metals, String color, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.metals = metals;
        this.color = color;
        this.vegetables = vegetables;
    }

    public List<String> getActualResultLog() {
        int sum = Integer.parseInt(getSummary().get(0)) + Integer.parseInt(getSummary().get(1));
        List<String> actualResult = new ArrayList<>();
        String elements = arrayToString(getElements(), ",");
        String vegetables = arrayToString(getVegetables(), ",");
        actualResult.add("Color: " + getColor());
        actualResult.add("Metal: " + getMetals());
        actualResult.add("Summary: " + sum);
        actualResult.add("Elements: " + elements);
        actualResult.add("Vegetables: " + vegetables);
        return actualResult;
    }

    private String arrayToString(List<String> stringArray, String delimiter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : stringArray) {
            stringBuilder.append(string).append(delimiter).append(' ');
        }
        return stringBuilder.substring(0, stringBuilder.length() - 2);
    }
}
