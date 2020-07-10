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
        return new UserDto().setEmailId(domain.getEmailId())
                .setId(domain.getId())
                .setAccessToken(domain.getAccessToken())
                .setPurpose(domain.getPurpose());
    }

    public User fromDto(UserDto dto) {
        return new User().setEmailId(dto.getEmailId())
                .setPurpose(dto.getPurpose());
    }
}
