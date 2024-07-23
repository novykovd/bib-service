package com.example.demo;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;


    @ElementCollection
    @CollectionTable(name = "isbn_collection", joinColumns =  @JoinColumn(name = "entity_id"))
    @Column(name = "isbn")
    private List<Long> isbnList;

    protected Customer(){}

    public Customer(String username, String password, List<Long> isbnList){
        this.password = password;
        this.username = username;
        this.isbnList = isbnList;
    }

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
    public List<Long> getIsbnList() { return isbnList;}
    public Long getId() {
        return id;
    }

    public void addIsbn(Long isbn){
        isbnList.add(isbn);
    }


}
