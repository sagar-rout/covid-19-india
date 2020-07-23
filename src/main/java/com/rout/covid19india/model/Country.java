package com.rout.covid19india.model;

/**
 * @author divya singh
 */
public enum Country {

    INDIA("INDIA", "IN");

    Country(String text, String code) {
        this.text = text;
        this.code = code;
    }

    private String text;
    private String code;

    public String getCode() {
        return code;
    }

    public Country setCode(String code) {
        this.code = code;
        return this;
    }

    public String getText() {
        return text;
    }

    public Country setText(String text) {
        this.text = text;
        return this;
    }
}
