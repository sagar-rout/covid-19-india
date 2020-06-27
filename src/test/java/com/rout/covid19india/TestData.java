package com.rout.covid19india;

import com.rout.covid19india.dto.UserDto;

import java.util.UUID;

public class TestData {

    public static UserDto create_userDto(){
        return new UserDto()
                .setPurpose("random-purpose")
                .setPassword("random-password")
                .setName("random-name");
    }
}
