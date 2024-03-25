package com.goko.hibernate.basic.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goko.hibernate.basic.entities.Person;
import com.goko.hibernate.basic.repositories.PersonRepository;

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
}
