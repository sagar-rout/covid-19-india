package com.rout.covid19india;

import com.rout.covid19india.controller.UserController;
import com.rout.covid19india.repository.UserRepository;
import com.rout.covid19india.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Covid19IndiaApplicationTests {

    @Autowired
    private UserController userController;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
        Assertions.assertThat(userController).isNotNull();
        Assertions.assertThat(userService).isNotNull();
        Assertions.assertThat(userRepository).isNotNull();
    }

}
