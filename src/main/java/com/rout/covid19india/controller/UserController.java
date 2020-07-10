package com.rout.covid19india.controller;

import com.rout.covid19india.dto.UserDto;
import com.rout.covid19india.service.UserService;
import com.rout.covid19india.validation.ValidateOnCreate;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Sagar Rout (sagar@rout.dev)
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

    @GetMapping(value = "/users", produces = APPLICATION_JSON_VALUE)
    public UserDto get(@RequestParam("emailId") String emailId) {
        if (emailId == null || emailId.isEmpty()) {
            throw new IllegalArgumentException("emailId is required.");
        }

        return userService.getByEmailId(emailId);
    }
}
