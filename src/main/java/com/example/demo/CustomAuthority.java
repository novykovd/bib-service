package com.example.demo;

import org.springframework.security.core.GrantedAuthority;

public class CustomAuthority implements GrantedAuthority {

    String role;

    @Override
    public String getAuthority() {
        return role;
    }

    public void setAuthority(String role){this.role = role;}
}
