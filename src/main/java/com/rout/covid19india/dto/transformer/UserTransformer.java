package com.rout.covid19india.dto.transformer;

import com.rout.covid19india.dto.UserDto;
import com.rout.covid19india.model.User;
import org.springframework.stereotype.Component;

/**
 * @author Sagar Rout
 */
@Component
public class UserTransformer {

    public UserDto fromDomain(User domain) {
        return new UserDto().setName(domain.getName())
                .setId(domain.getId())
                .setPassword(domain.getPassword())
                .setPurpose(domain.getPurpose());
    }

    public User fromDto(UserDto dto) {
        return new User().setName(dto.getName())
                .setPassword(dto.getPassword())
                .setPurpose(dto.getPurpose());
    }
}
