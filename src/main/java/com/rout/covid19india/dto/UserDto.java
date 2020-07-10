package com.rout.covid19india.dto;

import com.rout.covid19india.validation.ServerGeneratedValue;
import com.rout.covid19india.validation.ValidateOnCreate;
import com.rout.covid19india.validation.ValidateOnUpdate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

/**
 * @author Sagar Rout (sagar@rout.dev)
 */
public class UserDto {

    @ServerGeneratedValue(groups = ValidateOnCreate.class)
    @NotBlank(groups = ValidateOnUpdate.class, message = "id is requried.")
    private UUID id;

    @NotBlank(groups = {ValidateOnUpdate.class, ValidateOnCreate.class}, message = "name is required.")
    //@Email(groups = {ValidateOnUpdate.class, ValidateOnCreate.class}, message = "email id is not valid.")
    private String emailId;

    @ServerGeneratedValue(groups = ValidateOnCreate.class)
    @NotBlank(groups = {ValidateOnUpdate.class}, message = "accessToken is required.")
    private String accessToken;

    @NotBlank(groups = {ValidateOnUpdate.class, ValidateOnCreate.class}, message = "purpose is required.")
    private String purpose;

    public UUID getId() {
        return id;
    }

    public UserDto setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getEmailId() {
        return emailId;
    }

    public UserDto setEmailId(String emailId) {
        this.emailId = emailId;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public UserDto setAccessToken(String accessToken) {
        this.accessToken = accessToken;
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
                ", emailId='" + emailId + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
