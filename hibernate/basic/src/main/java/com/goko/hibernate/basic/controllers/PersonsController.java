package com.goko.hibernate.basic.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goko.hibernate.basic.entities.Person;
import com.goko.hibernate.basic.services.PersonsService;


@RestController
@RequestMapping("/api")
public class PersonsController {    

    @Autowired
    PersonsService personsService;

    @GetMapping("/personsDto")
    private ResponseEntity<Map<String, Object>> findAllDto() {
        return this.personsService.findAllByDto();
    }

    @GetMapping("/personsClass")
    private ResponseEntity<Map<String, Object>> findAllClass() {
        return this.personsService.findAllByClass();
    }

    @GetMapping("/personsMix")
    private ResponseEntity<Map<String, Object>> findAllMix() {
        return this.personsService.findAllMix();
    }

    @GetMapping("/persons")
    private ResponseEntity<Map<String, Object>> findAll() {
        return this.personsService.findAll();
    }

    @GetMapping("/persons/{personId}")
    private ResponseEntity<Map<String, Object>> findPersonById(@PathVariable Long personId) {
        return this.personsService.findById(personId);
    }

    @GetMapping("/persons/name/{personName}")
    private ResponseEntity<Map<String, Object>> findPersonByLikeName(@PathVariable String personName) {
        return this.personsService.findPersonByLikeName(personName);
    }

    @GetMapping("/persons/homeDirection/{personId}")
    private ResponseEntity<Map<String, Object>> findHomeDirectionByPersonId(@PathVariable Long personId) {
        return this.personsService.findHomeDirectionByPersonId(personId);
    }

    @PostMapping("/persons")
    private ResponseEntity<Map<String, Object>> createPerson(@RequestBody Person person) {
        return this.personsService.createPerson(person);
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Map<String, Object>> updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return this.personsService.updatePerson(id, person);
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<Map<String, Object>> deletePerson(@PathVariable Long id) {
        return this.personsService.deletePerson(id);
    }

    @GetMapping("/persons/getName/{id}")
    public ResponseEntity<Map<String, Object>> getMethodName(@PathVariable Long id) {
        return this.personsService.getNameById(id);
    }
    
}
