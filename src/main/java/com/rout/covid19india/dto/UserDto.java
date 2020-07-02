package com.rout.covid19india.dto;

import com.rout.covid19india.validation.ServerGeneratedValue;
import com.rout.covid19india.validation.ValidateOnCreate;
import com.rout.covid19india.validation.ValidateOnUpdate;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

/**
 * @author Sagar Rout
 */
public class UserDto {

    @ServerGeneratedValue(groups = ValidateOnCreate.class)
    @NotBlank(groups = ValidateOnUpdate.class, message = "id is requried.")
    private UUID id;

    @NotBlank(groups = {ValidateOnUpdate.class, ValidateOnCreate.class}, message = "name is required.")
    private String name;

    @NotBlank(groups = {ValidateOnUpdate.class, ValidateOnCreate.class}, message = "password is required.")
    private String password;

    @NotBlank(groups = {ValidateOnUpdate.class, ValidateOnCreate.class}, message = "purpose is required.")
    private String purpose;

    public UUID getId() {
        return id;
    }

    public UserDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPurpose() {
        return purpose;
    }

    public UserDto setPurpose(String purpose) {
        this.purpose = purpose;
        return this;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
