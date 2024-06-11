package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    CustomerRepository repository;

    @GetMapping
    public String register(Model model){
        model.addAttribute("user", new PojoUser());
        return "register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute PojoUser user){
        Customer newCustomer = new Customer(user.username, user.password);
        repository.save(newCustomer);
        return "redirect:/login";
    }
}
