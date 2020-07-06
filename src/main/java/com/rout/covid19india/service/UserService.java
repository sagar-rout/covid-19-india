package com.rout.covid19india.service;

import com.rout.covid19india.dto.UserDto;
import com.rout.covid19india.dto.transformer.UserTransformer;
import com.rout.covid19india.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author Sagar Rout
 */
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserTransformer userTransformer;

    public UserService(UserRepository userRepository, UserTransformer userTransformer) {
        this.userRepository = userRepository;
        this.userTransformer = userTransformer;
    }

    public UserDto saveOrUpdate(UserDto userDto) {
        return userTransformer.fromDomain(userRepository.save(userTransformer.fromDto(userDto)));
    }

}