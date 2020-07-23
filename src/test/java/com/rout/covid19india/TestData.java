package com.rout.covid19india;

public class TestData {

    public static UserDto create_userDto() {
        return new UserDto()
                .setPurpose("random-purpose")
                .setEmailId("sagar@rout.dev");
    }
}
