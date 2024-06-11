package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest

public class JpaTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testFindById(){
        Customer user = new Customer("shaboink", "boink");
        customerRepository.save(user);

        Customer foundCustomer = customerRepository.findByUsername("boink");

        assert user == foundCustomer;
    }

}
