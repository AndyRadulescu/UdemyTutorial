package com.example.udemytutorial.repository;

import com.example.udemytutorial.model.Customer;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {
}
