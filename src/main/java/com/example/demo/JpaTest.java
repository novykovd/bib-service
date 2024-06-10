package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@DataJpaTest

public class JpaTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindById(){
        User user = new User();
        user.setPassword("shaboink");
        user.setUsername("boink");
        userRepository.save(user);

        User foundUser = userRepository.findByUsername("boink");

        assert user == foundUser;
    }

}
