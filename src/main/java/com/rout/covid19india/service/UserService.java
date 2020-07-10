package com.rout.covid19india.service;

import com.diffplug.common.base.Errors;
import com.rout.covid19india.dto.UserDto;
import com.rout.covid19india.dto.transformer.UserTransformer;
import com.rout.covid19india.model.User;
import com.rout.covid19india.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.security.SecureRandom;

/**
 * @author Sagar Rout (sagar@rout.dev)
 */
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final UserTransformer userTransformer;
    private final HttpServletRequest httpServletRequest;

    public UserService(UserRepository userRepository, UserTransformer userTransformer, HttpServletRequest httpServletRequest) {
        this.userRepository = userRepository;
        this.userTransformer = userTransformer;
        this.httpServletRequest = httpServletRequest;
    }

    @Transactional
    public UserDto saveOrUpdate(UserDto userDto) {
        final User user = userTransformer.fromDto(userDto);
        user.setAccessToken(getRandomToken());

        return userTransformer.fromDomain(userRepository.save(user));
    }

    /**
     * Generate random token using {@link SecureRandom}
     *
     * @return random secure token string
     */
    private String getRandomToken() {
        SecureRandom random = Errors.rethrow().wrap(() -> SecureRandom.getInstance("SHA1PRNG")).get();
        return RandomStringUtils.random(20, 0, 0, true, true, null, random);
    }

    /**
     * Validate access token
     *
     * @param accessToken
     * @return
     */
    @Transactional(readOnly = true)
    public boolean isAccessTokenValid(String accessToken) {
        return userRepository.existsByAccessToken(accessToken);
    }


    @Transactional(readOnly = true)
    public UserDto getByEmailId(String emailId) {

        final User user = userRepository.findByEmailId(emailId).orElseThrow(() ->
                new NoDataFoundException(String.format("User %s not present", emailId)));

        boolean isValidUser = httpServletRequest.getHeader("access_token").equals(user.getAccessToken());

        if (!isValidUser) {
            throw new AccessForbiddenException("Bad !!!! :) You are not allowed to access someone else information.");
        }

        return userTransformer.fromDomain(user);
    }
}