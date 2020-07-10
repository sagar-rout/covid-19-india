package com.rout.covid19india.model;

/**
 * @author divya singh
 */
public enum Country {

    INDIA("INDIA");

    Country(String text) {
        this.text = text;
    }

    private String text;

    public String getText() {
        return text;
    }

    public Country setText(String text) {
        this.text = text;
        return this;
    }
}
