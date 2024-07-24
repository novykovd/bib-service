package com.example.demo;


import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    CustomerRepository repository;

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/home")
    public String home(Principal principal, Model model){
        if(principal != null) {
            model.addAttribute("username", principal.getName());
            Customer customer = repository.findByUsername(principal.getName());
            model.addAttribute("isbnList", customer.getIsbnList());
            return "index";
        }else{
            return "error";
        }
    }

    @GetMapping("/edit")
    public String edit(Model model, Principal principal){

        if(principal != null) {
            Customer customer = repository.findByUsername(principal.getName());
            model.addAttribute("isbnList", customer.getIsbnList());
            model.addAttribute("username", customer.getUsername());
            log.info(customer.getIsbnList().toString());
            return "edit";
        }else{
            return "error";
        }
    }

    @PostMapping("/edit")
    public String editPost(@RequestParam("isbn") List<Long> ibsnList, Principal principal){
        log.info(ibsnList.toString());

        Customer customer = repository.findByUsername(principal.getName());
        customer.clearIsbn();

        for (Long num : ibsnList) {
            int length = String.valueOf(num).length();
            if (length != 13) {
                return "error";
            }

            customer.addIsbn(num);
            repository.save(customer);
        }
        return "redirect:/user/home";
    }

    @GetMapping("/{id}")
    public String viewer(@PathVariable String id, Model model){
        return "index";
    }


}
