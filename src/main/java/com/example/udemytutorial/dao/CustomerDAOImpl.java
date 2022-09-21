package com.example.udemytutorial.dao;

import com.example.udemytutorial.model.Customer;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory factory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        Session currentSession = factory.openSession();

        Query<Customer> query = currentSession.createQuery("from Customer", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        Session currentSession = factory.openSession();
        currentSession.save(customer);
    }
}
