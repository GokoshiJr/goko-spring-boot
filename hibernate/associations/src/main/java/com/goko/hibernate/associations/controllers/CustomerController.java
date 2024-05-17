package com.goko.hibernate.associations.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goko.hibernate.associations.entities.Customer;
import com.goko.hibernate.associations.entities.Invoice;
import com.goko.hibernate.associations.services.CustomerService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class CustomerController {
    
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    private ResponseEntity<Map<String, Object>> findAll() {
        return this.customerService.findAll();
    }

    @PostMapping("/customers")
    private ResponseEntity<Map<String, Object>> createCustomer(@RequestBody Customer customer) {
        return this.customerService.createCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Map<String, Object>> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return this.customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Map<String, Object>> deleteCustomer(@PathVariable Long id) {
        return this.customerService.deleteCustomer(id);
    }

    @PostMapping("/customers/{id}/invoice")
    private ResponseEntity<Map<String, Object>> createInvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
        return this.customerService.createInvoice(id, invoice);
    }
    
}
