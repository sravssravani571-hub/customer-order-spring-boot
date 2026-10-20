package com.example.customer_order.controller;

import com.example.customer_order.model.Customer;
import com.example.customer_order.service.CustomerJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CustomerController {

    @Autowired
    private CustomerJpaService customerJpaService;

    @GetMapping("/customers")
    public ArrayList<Customer> getCustomers() {
        return customerJpaService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomerById(@PathVariable("customerId") int customerId) {
        return customerJpaService.getCustomerById(customerId);
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerJpaService.addCustomer(customer);
    }

    @PutMapping("/customers/{customerId}")
    public Customer updateCustomer(
            @PathVariable("customerId") int customerId,
            @RequestBody Customer customer) {

        return customerJpaService.updateCustomer(customerId, customer);
    }

    @DeleteMapping("/customers/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId) {
        customerJpaService.deleteCustomer(customerId);
    }
}