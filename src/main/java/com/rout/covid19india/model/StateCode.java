package com.rout.covid19india.model;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum StateCode {
    AD("AD"),
    AR("AR"),
    AS("AS"),
    BR("BR"),
    CG("CG"),
    DL("DL"),
    GA("GA"),
    GJ("GJ"),
    HR("HR"),
    HP("HP"),
    JK("JK"),
    JH("JH"),
    KA("KA"),
    KL("KL"),
    LD("LD"),
    MP("MP"),
    MH("MH"),
    MN("MN"),
    ML("ML"),
    MZ("MZ"),
    NL("NL"),
    OD("OD"),
    PY("PY"),
    PB("PB"),
    RJ("RJ"),
    SK("SK"),
    TN("TN"),
    TS("TS"),
    TR("TR"),
    UP("UP"),
    UK("UK"),
    WB("WB"),
    AN("AN"),
    CH("CH"),
    DN("DN"),
    DD("DD"),
    LA("LA"),
    OT("OT");

    public static final Map<String, StateCode> STATE_CODE_MAP = Arrays.stream(StateCode.values())
            .collect(Collectors.toMap(StateCode::getCode, Function.identity()));

    private String code;

    StateCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Optional<StateCode> fromStringOptional(String stateCode) {
        return Optional.ofNullable(STATE_CODE_MAP.get(stateCode));
    }

    public static StateCode fromString(String stateCode) {
        return STATE_CODE_MAP.get(stateCode);
    }
}
