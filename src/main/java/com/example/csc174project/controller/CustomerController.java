package com.example.csc174project.controller;

import com.example.csc174project.dao.CustomerDAO;
import com.example.csc174project.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"https://gleeful-profiterole-1a83ad.netlify.app/"})

public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @PostMapping("/createCustomer")
    public String insertCustomer(@RequestBody Customer customer) {
        return customerDAO.insertCustomer(customer);
    }

    @GetMapping("/selectCustomer")
    public String selectCustomer(@RequestParam String customerID) {

        return customerDAO.selectCustomer(customerID);
    }
}
