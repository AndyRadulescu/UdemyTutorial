package com.example.udemytutorial.service;

import com.example.udemytutorial.dao.CustomerDAO;
import com.example.udemytutorial.model.Customer;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        customer.setId(UUID.randomUUID());
        System.out.println(customer);
        customerDAO.saveCustomer(customer);
    }
}
