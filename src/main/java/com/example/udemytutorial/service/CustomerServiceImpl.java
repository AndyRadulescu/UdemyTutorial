package com.example.udemytutorial.service;

import com.example.udemytutorial.dao.CustomerDAO;
import com.example.udemytutorial.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    public void saveCustomer(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(UUID.randomUUID());
        }
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(UUID id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    public void deleteCustomer(UUID id) {
        customerDAO.deleteCustomer(id);
    }
}
