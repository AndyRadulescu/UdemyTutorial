package com.example.udemytutorial.service;

import com.example.udemytutorial.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(UUID id);
}
