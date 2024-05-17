package com.goko.hibernate.associations.repositories;

import org.springframework.data.repository.CrudRepository;

import com.goko.hibernate.associations.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long>{
    
}
