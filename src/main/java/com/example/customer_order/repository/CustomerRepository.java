package com.example.customer_order.repository;

import com.example.customer_order.model.Customer;

import java.util.ArrayList;

public interface CustomerRepository {

    ArrayList<Customer> getCustomers();

    Customer getCustomerById(int customerId);

    Customer addCustomer(Customer customer);

    Customer updateCustomer(int customerId, Customer customer);

    void deleteCustomer(int customerId);
}