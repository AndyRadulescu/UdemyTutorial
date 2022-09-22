package com.example.udemytutorial.dao;

import com.example.udemytutorial.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory factory;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        Session currentSession = factory.openSession();

        Query<Customer> query = currentSession.createQuery("from Customer order by last_name", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = factory.openSession();
        currentSession.beginTransaction();
        System.out.println(customer);
        currentSession.saveOrUpdate(customer);
        currentSession.getTransaction().commit();
    }

    @Override
    public Customer getCustomer(UUID id) {
        Session currentSession = factory.openSession();
        return currentSession.get(Customer.class, id);
    }
}
