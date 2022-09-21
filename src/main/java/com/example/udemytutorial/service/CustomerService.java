package com.example.udemytutorial.service;

import com.example.udemytutorial.model.Customer;
import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);
}
