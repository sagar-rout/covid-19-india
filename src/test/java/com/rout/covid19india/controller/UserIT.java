package com.rout.covid19india.controller;

import com.rout.covid19india.AbstractIT;
import com.rout.covid19india.dto.UserDto;
import com.rout.covid19india.model.User;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class UserIT extends AbstractIT {

    @Test
    public void registerUser() {
        // GIVEN
        final UserDto request = new UserDto().setEmailId("sagar@rout.dev").setPurpose("Data analytics");

        // WHEN
        final ResponseEntity<UserDto> responseEntity = testRestTemplate.postForEntity("/users", request, UserDto.class);

        // THEN
        Assertions.assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        final UserDto response = responseEntity.getBody();
        Assertions.assertThat(response.getAccessToken()).isNotNull();
        Assertions.assertThat(response.getEmailId()).isEqualTo(request.getEmailId());
        Assertions.assertThat(response.getPurpose()).isEqualTo(request.getPurpose());
    }


    @Test
    public void getUserByEmailId() {

        // GIVEN
        final UserDto request = new UserDto().setEmailId("test@rout.dev").setPurpose("Data analytics");
        final ResponseEntity<UserDto> responseEntity = testRestTemplate.postForEntity("/users", request, UserDto.class);

        // WHEN
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("emailId", request.getEmailId());

        HttpHeaders headers = new HttpHeaders();
        headers.add("access_token", responseEntity.getBody().getAccessToken());

        final ResponseEntity<User> response = testRestTemplate.exchange("/users?emailId="+request.getEmailId(), HttpMethod.GET, new HttpEntity<>(headers), User.class);

        // THEN
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getEmailId()).isEqualTo(request.getEmailId());
        Assertions.assertThat(response.getBody().getPurpose()).isEqualTo(request.getPurpose());
    }
}
