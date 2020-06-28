package com.rout.covid19india.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rout.covid19india.TestData;
import com.rout.covid19india.dto.UserDto;
import com.rout.covid19india.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldRegisterUser() throws Exception {
        // GIVEN
        final UUID id = UUID.randomUUID();
        final UserDto requestUserDto = TestData.create_userDto();

        final UserDto savedUserDto = TestData.create_userDto();
        savedUserDto.setId(id);

        Mockito.when(userService.saveOrUpdate(Mockito.any(UserDto.class))).thenReturn(savedUserDto);

        // WHEN
        final MockHttpServletResponse response = this.mockMvc
                .perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(requestUserDto)))
                .andReturn().getResponse();

        // THEN
        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        Assertions.assertThat(response.getContentAsString()).isEqualTo(
                objectMapper.writeValueAsString(savedUserDto)
        );
    }

    @Test
    public void shouldFailToRegisterInAbsenceOfRequiredFields() throws Exception {
        // GIVEN
        final UserDto emptyRequestBody = new UserDto();

        // WHEN
        final MockHttpServletResponse response = this.mockMvc
                .perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(emptyRequestBody)))
                .andReturn().getResponse();

        // THEN
        Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }
}
