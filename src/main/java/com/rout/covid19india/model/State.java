package com.rout.covid19india.model;

public enum State {

    ANDAMAN_AND_NICOBAR("ANDAMAN_AND_NICOBAR"),
    ANDHRA_PRADESH("ANDHRA_PRADESH"),
    ARUNACHAL_PRADESH("ARUNACHAL_PRADESH"),
    ASSAM("ASSAM");

    private String text;

    State(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public State setText(String text) {
        this.text = text;
        return this;
    }
}


