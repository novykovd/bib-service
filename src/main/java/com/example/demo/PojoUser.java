package com.example.demo;

import java.util.List;

public class PojoUser {
    public String username;
    public String password;
    public List<String> isbnList;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setIsbnList(List<String> isbns){this.isbnList = isbns;}

    public List<String> getIsbnList(){return isbnList;}
}
