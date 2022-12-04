package com.example.csc174project.controller;

import com.example.csc174project.dao.CustomerDAO;
import com.example.csc174project.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"https://gleeful-profiterole-1a83ad.netlify.app/"})

public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    //handles POST requests to insert value from the frontend
    @PostMapping("/createCustomer")
    public String insertCustomer(@RequestBody Customer customer) {
        return customerDAO.insertCustomer(customer);
    }

    //handles GET requests to display values from the customer table in the frontend
    @GetMapping("/tableCustomer")
    public List<Customer> tableCustomer() {
        return customerDAO.customerTable();
    }
}
