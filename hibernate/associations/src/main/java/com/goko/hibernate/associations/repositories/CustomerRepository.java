package com.goko.hibernate.associations.repositories;

import org.springframework.data.repository.CrudRepository;

import com.goko.hibernate.associations.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
}
