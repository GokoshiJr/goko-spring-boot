package com.goko.hibernate.associations.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.goko.hibernate.associations.entities.Address;
import com.goko.hibernate.associations.entities.Customer;
import com.goko.hibernate.associations.entities.Invoice;
import com.goko.hibernate.associations.repositories.CustomerRepository;
import com.goko.hibernate.associations.repositories.InvoiceRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public ResponseEntity<Map<String, Object>> findAll() {
        Map<String, Object> res = new HashMap<>();
        res.put("customers", customerRepository.findAll());
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity<Map<String, Object>> createCustomer(Customer customer) {
        Map<String, Object> res = new HashMap<>();
        this.customerRepository.save(customer);
        res.put("message", "Customer created successfully");
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity<Map<String, Object>> updateCustomer(Long id, Customer customer) {
        Map<String, Object> res = new HashMap<>();
        var optionalCustomer = this.customerRepository.findById(id);

        if (optionalCustomer.isEmpty()) {
            res.put("message", "Customer with the id: " + id + " not found to update");
            return new ResponseEntity<>(res, HttpStatus.valueOf(400));
        }

        var c = optionalCustomer.get();
        c.setName(customer.getName());
        c.setLastName(customer.getLastName());
        this.customerRepository.save(c);
        res.put("message", "Customer updated successfully");    

        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity<Map<String, Object>> deleteCustomer(Long id) {
        Map<String, Object> res = new HashMap<>();
        var optionalCustomer = this.customerRepository.findById(id);

        if (optionalCustomer.isEmpty()) {
            res.put("message", "Customer with id " + id + " not found to delete");
            return new ResponseEntity<>(res, HttpStatus.valueOf(400));
        }
        
        this.customerRepository.deleteById(id);
        res.put("message", "Customer with id " + id + " deleted successfully");        
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }
    
    @Override
    public ResponseEntity<Map<String, Object>> createInvoice(Long userId, Invoice invoice) {
        Map<String, Object> res = new HashMap<>();
        res.put("date", new Date().toString());

        var optionalCustomer = this.customerRepository.findById(userId);

        if (optionalCustomer.isEmpty()) {
            res.put("message", "User " + userId + " not found to create Invoice");
            return new ResponseEntity<>(res, HttpStatus.valueOf(400));
        }
        
        invoice.setCustomer(optionalCustomer.get());        
        this.invoiceRepository.save(invoice);
        res.put("message", "Invoice saved to User " + userId + " successfull");
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));        
    }

    @Override
    public ResponseEntity<Map<String, Object>> createAddress(Long userId, Address address) {
        Map<String, Object> res = new HashMap<>();
        res.put("date", new Date().toString());

        var optionalCustomer = this.customerRepository.findById(userId);

        if (optionalCustomer.isEmpty()) {
            res.put("message", "User " + userId + " not found to create Address");
            return new ResponseEntity<>(res, HttpStatus.valueOf(400));
        }

        var customer = optionalCustomer.get();        
        customer.getAddresses().add(address);
        this.customerRepository.save(customer);

        res.put("message", "Address saved to User " + userId + " successfull");
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));        
    }
}
