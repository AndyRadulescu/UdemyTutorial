package com.example.udemytutorial.dao;

import com.example.udemytutorial.model.Customer;
import java.util.List;

public interface CustomerDAO {
    public List<Customer> getCustomers();
    public void saveCustomer(Customer customer);
}
