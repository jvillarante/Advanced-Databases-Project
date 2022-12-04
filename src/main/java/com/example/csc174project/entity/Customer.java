package com.example.csc174project.entity;

import lombok.Data;

@Data
public class Customer {

    private String customerID;
    private String firstName;
    private String lastName;
    private String state;
    private String city;
    private String zipCode;
    private String street;
}