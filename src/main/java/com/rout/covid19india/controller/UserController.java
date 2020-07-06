package com.rout.covid19india.controller;

import com.rout.covid19india.dto.UserDto;
import com.rout.covid19india.service.UserService;
import com.rout.covid19india.validation.ValidateOnCreate;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Sagar Rout
 */
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/users", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserDto register(@Validated(ValidateOnCreate.class) @RequestBody UserDto userDto) {
        return userService.saveOrUpdate(userDto);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping(value = "/users/{uuid}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserDto update(@Valid @RequestBody UserDto userDto, @PathVariable("uuid") UUID id) {

        if (!id.equals(userDto.getId())) {
            throw new IllegalArgumentException("request id does not match with request uri id.");
        }
        return userService.saveOrUpdate(userDto);
    }
}
