package com.goko.hibernate.basic.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goko.hibernate.basic.entities.Person;
import com.goko.hibernate.basic.repositories.PersonRepository;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/persons")
    private ResponseEntity<?> home() {
        var persons = (List<Person>) personRepository.findAll();
        Map<String, Object> res = new HashMap<>();
        res.put("persons", persons);
        res.put("date", new Date().toString());
        return ResponseEntity.ok(res);
    }

    @GetMapping("/persons/{personId}")
    private ResponseEntity<?> findPersonById(@PathVariable Long personId) {
        Optional<Person> person = personRepository.findById(personId);
        Map<String, Object> res = new HashMap<>();
        res.put("person", person);
        res.put("date", new Date().toString());
        return ResponseEntity.ok(res);
    }

    @GetMapping("/persons/name/{personName}")
    private ResponseEntity<?> findPersonByLikeName(@PathVariable String personName) {
        Optional<Person> person = personRepository.findOneLikeName(personName);
        Map<String, Object> res = new HashMap<>();
        res.put("person", person);
        res.put("date", new Date().toString());
        return ResponseEntity.ok(res);
    }

    @GetMapping("/persons/homeDirection/{personId}")
    private ResponseEntity<?> findHomeDirectionByPersonId(@PathVariable Long personId) {
        var homeDirection = personRepository.findHomeDirectionByPersonId(personId);

        homeDirection.stream().forEach(h -> {
            System.out.println(h[0] + ", " + h[1]);
        });

        Map<String, Object> res = new HashMap<>();
        res.put("homeDirection", homeDirection);
        res.put("date", new Date().toString());
        return ResponseEntity.ok(res);
    }

    @PostMapping("/persons")
    private ResponseEntity<?> createPerson(@RequestBody Person person) {
        this.personRepository.save(person);
        Map<String, Object> res = new HashMap<>();
        res.put("date", new Date().toString());
        res.put("message", "Person created successfully");
        return ResponseEntity.ok(res);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PutMapping("/persons/{id}")
    public ResponseEntity<?> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        var optionalPerson = this.personRepository.findById(id);
        Map<String, Object> res = new HashMap<>();
        res.put("date", new Date().toString());
        if (optionalPerson.isPresent()) {
            var p = optionalPerson.get();
            p.setName(person.getName());
            p.setLastName(person.getLastName());
            p.setAge(person.getAge());
            p.setHomeDirection(person.getHomeDirection());
            this.personRepository.save(p);
            res.put("message", "Person updated successfully");
            return ResponseEntity.ok(res);
        }
        else {
            res.put("message", "No se consigue a las persona con el id " + id);
            return new ResponseEntity(res, HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @DeleteMapping("/persons/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        var optionalPerson = this.personRepository.findById(id);
        Map<String, Object> res = new HashMap<>();
        res.put("date", new Date().toString());

        if (optionalPerson.isPresent()) {
            this.personRepository.deleteById(id);
            res.put("message", "Person with id " + id + " deleted successfully");
            return ResponseEntity.ok(res);
        }
        
        res.put("message", "No se consigue a la persona con el id " + id);
        return new ResponseEntity(res, HttpStatus.BAD_REQUEST);
    }
}
