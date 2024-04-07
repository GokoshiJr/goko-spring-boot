package com.goko.hibernate.basic.services;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.goko.hibernate.basic.entities.Person;

public interface PersonsService {

    ResponseEntity<Map<String, Object>> findAll();
    
    ResponseEntity<Map<String, Object>> findById(Long personId);

    ResponseEntity<Map<String, Object>> findPersonByLikeName(String personName);

    ResponseEntity<Map<String, Object>> findHomeDirectionByPersonId(Long personId);

    ResponseEntity<Map<String, Object>> createPerson(Person person);

    ResponseEntity<Map<String, Object>> updatePerson(Long id, Person person);

    ResponseEntity<Map<String, Object>> deletePerson(Long id);

    ResponseEntity<Map<String, Object>> getNameById(Long id);
}
