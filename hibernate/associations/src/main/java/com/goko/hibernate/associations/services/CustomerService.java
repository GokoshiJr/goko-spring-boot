package com.goko.hibernate.associations.services;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.goko.hibernate.associations.entities.Customer;
import com.goko.hibernate.associations.entities.Invoice;


public interface CustomerService {

    ResponseEntity<Map<String, Object>> findAll();

    ResponseEntity<Map<String, Object>> createCustomer(Customer customer);

    ResponseEntity<Map<String, Object>> updateCustomer(Long id, Customer customer);

    ResponseEntity<Map<String, Object>> deleteCustomer(Long id);

    ResponseEntity<Map<String, Object>> createInvoice(Long id, Invoice invoice);
    
}
