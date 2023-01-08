package com.epam.tc.hw7.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    public MetalsInfo(List<String> summary, List<String> elements, String metals, String color, List<String> vegetables) {
        this.summary = summary;
        this.elements = elements;
        this.metals = metals;
        this.color = color;
        this.vegetables = vegetables;
    }

    @Override
    public String toString() {
        return "MetalsInfo{" +
                "summary=" + summary +
                ", elements=" + elements +
                ", metals='" + metals + '\'' +
                ", color='" + color + '\'' +
                ", vegetables=" + vegetables +
                '}';
    }
}
