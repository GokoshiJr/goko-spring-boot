package com.goko.hibernate.basic.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.goko.hibernate.basic.entities.Person;
import com.goko.hibernate.basic.repositories.PersonsRepository;

@Service
public class PersonsServiceImpl implements PersonsService {
    
    @Autowired
    PersonsRepository personRepository;
    
    @Override
    public ResponseEntity<Map<String, Object>> findAllByDto() {
        Map<String, Object> res = new HashMap<>();        
        var persons = personRepository.findAllByDto();        
        res.put("persons", persons);
        res.put("date", new Date().toString());
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity<Map<String, Object>> findAllByClass() {
        Map<String, Object> res = new HashMap<>();        
        var persons = personRepository.findAllByClass();        
        res.put("persons", persons);
        res.put("date", new Date().toString());
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

    @Override
    public ResponseEntity<Map<String, Object>> findAllMix() {
        Map<String, Object> res = new HashMap<>();        
        var persons = personRepository.mix();        
        res.put("persons", persons);
        res.put("date", new Date().toString());
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }
    
    public ResponseEntity<Map<String, Object>> findAll() {
        Map<String, Object> res = new HashMap<>();        
        var persons = personRepository.findAll();        
        res.put("persons", persons);
        res.put("date", new Date().toString());
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

    public ResponseEntity<Map<String, Object>> findById(Long personId) {
        Map<String, Object> res = new HashMap<>();
        var person = personRepository.findById(personId);
        res.put("date", new Date().toString());
        if (person.isPresent()) {
            res.put("person", person);
        } else {
            res.put("message", "No se encuentra la persona con el id " + personId);
        }
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

    public ResponseEntity<Map<String, Object>> findPersonByLikeName(String personName) {
        Map<String, Object> res = new HashMap<>();
        var person = personRepository.findOneLikeName(personName);
        res.put("date", new Date().toString());
        if (person.isPresent()) {
            res.put("person", person);
        } else {
            res.put("message", "No se encontraron resultados");
        }
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

    public ResponseEntity<Map<String, Object>> findHomeDirectionByPersonId(Long personId) {
        var homeDirection = personRepository.findHomeDirectionByPersonId(personId);
        Map<String, Object> res = new HashMap<>();
        res.put("date", new Date().toString());        
        if (homeDirection.size() == 0) {
            res.put("message", "No se encontro la persona con el id " + personId);
        } else {
            res.put("homeDirection", homeDirection);
        }
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

    public ResponseEntity<Map<String, Object>> createPerson(Person person) {
        this.personRepository.save(person);
        Map<String, Object> res = new HashMap<>();
        res.put("date", new Date().toString());
        res.put("message", "Person created successfully");
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

    public ResponseEntity<Map<String, Object>> updatePerson(Long id, Person person) {
        Map<String, Object> res = new HashMap<>();
        var optionalPerson = this.personRepository.findById(id);
        res.put("date", new Date().toString());
        if (optionalPerson.isPresent()) {
            var p = optionalPerson.get();
            p.setName(person.getName());
            p.setLastName(person.getLastName());
            p.setAge(person.getAge());
            p.setHomeDirection(person.getHomeDirection());
            this.personRepository.save(p);
            res.put("message", "Person updated successfully");
        } else {
            res.put("message", "No se consigue a las persona con el id " + id);
        }
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

    public ResponseEntity<Map<String, Object>> deletePerson(Long id) {
        Map<String, Object> res = new HashMap<>();
        var optionalPerson = this.personRepository.findById(id);
        res.put("date", new Date().toString());
        if (optionalPerson.isPresent()) {
            this.personRepository.deleteById(id);
            res.put("message", "Person with id " + id + " deleted successfully");
        } else {
            res.put("message", "No se consigue a la persona con el id " + id);
        }
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

    public ResponseEntity<Map<String, Object>> getNameById(Long id) {
        Map<String, Object> res = new HashMap<>();
        var name = this.personRepository.getNameById(id);        
        if (name == null) {
            res.put("message", "No se encontro la persona con el id " + id);
        } else {
            res.put("name", name);
        }
        res.put("date", new Date().toString());        
        return new ResponseEntity<>(res, HttpStatus.valueOf(200));
    }

}
