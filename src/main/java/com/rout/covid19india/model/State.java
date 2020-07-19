package com.rout.covid19india.model;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum State {

    ANDAMAN_AND_NICOBAR("Andaman and Nicobar", StateCode.AN),
    ANDHRA_PRADESH("Andhra Pradesh", StateCode.AD),
    ARUNACHAL_PRADESH("Arunachal Pradesh", StateCode.AR),
    ASSAM("Assam", StateCode.AS),
    BIHAR("Bihar", StateCode.BR),
    CHANDIGARH("Chandigarh", StateCode.CH),
    CHHATTISGARH("Chhattisgarh", StateCode.CG),
    DADRA_AND_NAGAR_HAVELI_AND_DAMAN("Dadra and Nagar Haveli and Daman", StateCode.DN),
    DAMAN_AND_DIU("Daman and Diu", StateCode.DD),
    DELHI("Delhi", StateCode.DL),
    GOA("Goa", StateCode.GA),
    GUJARAT("Gujarat", StateCode.GJ),
    HARYANA("Haryana", StateCode.HR),
    HIMACHAL_PRADESH("Himachal Pradesh", StateCode.HP),
    JAMMU_AND_KASHMIR("Jammu and Kashmir", StateCode.JK),
    JHARKHAND("Jharkhand", StateCode.JH),
    KARNATAKA("Karnataka", StateCode.KA),
    KERALA("Kerala", StateCode.KL),
    LADAKH("Ladakh", StateCode.LA),
    LAKSHADWEEP("Lakshadweep", StateCode.LD),
    MADHYA_PRADESH("Madhya Pradesh", StateCode.MP),
    MAHARASHTRA("Maharashtra", StateCode.MH),
    MANIPUR("Manipur", StateCode.MN),
    MEGHALAYA("Meghalaya", StateCode.ML),
    MIZORAM("Mizoram", StateCode.MZ),
    NAGALAND("Nagaland", StateCode.NL),
    ODISHA("Odisha", StateCode.OD),
    PUDUCHERRY("Puducherry", StateCode.PY),
    PUNJAB("Punjab", StateCode.PB),
    RAJASTHAN("Rajasthan", StateCode.RJ),
    SIKKIM("Sikkim", StateCode.SK),
    TAMIL_NADU("Tamil Nadu", StateCode.TN),
    TELENGANA("Telengana", StateCode.TS),
    TRIPURA("Tripura", StateCode.TR),
    UTTAR_PRADESH("Uttar Pradesh", StateCode.UP),
    UTTARAKHAND("Uttarakhand", StateCode.UK),
    WEST_BENGAL("West Bengal", StateCode.WB);

    private String text;
    private StateCode code;

    private static final Map<String, State> byText = Arrays.stream(State.values())
            .collect(Collectors.toMap(State::getText, Function.identity()));

    State(String text, StateCode code) {
        this.text = text;
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public State setText(String text) {
        this.text = text;
        return this;
    }

    public StateCode getCode() {
        return code;
    }

    public State setCode(StateCode code) {
        this.code = code;
        return this;
    }

    public static Optional<State> fromText(String text) {
        return Optional.ofNullable(byText.get(text));
    }
}


