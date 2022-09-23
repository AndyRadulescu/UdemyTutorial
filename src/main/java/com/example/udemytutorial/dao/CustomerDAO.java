package com.example.udemytutorial.dao;

import com.example.udemytutorial.model.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerDAO {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(UUID id);

    void deleteCustomer(UUID theId);
}
