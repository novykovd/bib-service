package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    protected Customer(){}

    public Customer(String username, String password){
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword(){
        return password;
    }

    public Long getId() {
        return id;
    }
}
