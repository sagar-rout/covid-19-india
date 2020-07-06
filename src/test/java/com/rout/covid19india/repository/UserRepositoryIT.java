package com.rout.covid19india.repository;

import com.rout.covid19india.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("it")
public class UserRepositoryIT {


    @Autowired
    private UserRepository userRepository;

    @Test
    public void save() {
        // given

        userRepository.save(new User().setEmailId("sa").setAccessToken("sa").setPurpose("sa"));
    }
}
