package com.example.customer_order.service;

import com.example.customer_order.model.Customer;
import com.example.customer_order.repository.CustomerJpaRepository;
import com.example.customer_order.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerJpaService implements CustomerRepository {

    @Autowired
    private CustomerJpaRepository customerJpaRepository;

    @Override
    public ArrayList<Customer> getCustomers() {
        List<Customer> customerList = customerJpaRepository.findAll();
        return new ArrayList<>(customerList);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        try {
            return customerJpaRepository.findById(customerId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerJpaRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(int customerId, Customer customer) {
        try {
            Customer newCustomer = customerJpaRepository.findById(customerId).get();

            if (customer.getCustomerName() != null) {
                newCustomer.setCustomerName(customer.getCustomerName());
            }

            if (customer.getEmail() != null) {
                newCustomer.setEmail(customer.getEmail());
            }

            return customerJpaRepository.save(newCustomer);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCustomer(int customerId) {
        try {
            customerJpaRepository.deleteById(customerId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}