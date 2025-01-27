package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    CustomerRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @CrossOrigin
    @GetMapping("/userDetails")
    public Customer getUser() throws Exception{
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        try{
            username = ((UserDetails) principal).getUsername();
            return customerRepository.findByUsername(username);
        }catch(Exception e){
            logger.info("something went wrong");
            throw e;
        }
    }
}
