package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/home")
    public String home(Principal principal, Model model){
        if(principal != null) {
            return "index";
        }else{
            return "error";
        }
    }

    @GetMapping("/{id}")
    public String viewer(@PathVariable String id, Model model){
        return "index";
    }


}
