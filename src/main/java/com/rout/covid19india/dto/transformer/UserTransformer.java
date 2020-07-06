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
        return new UserDto().setName(domain.getEmailId())
                .setId(domain.getId())
                .setPurpose(domain.getPurpose());
    }

    public User fromDto(UserDto dto) {
        return new User().setEmailId(dto.getName())
                .setPurpose(dto.getPurpose());
    }
}
