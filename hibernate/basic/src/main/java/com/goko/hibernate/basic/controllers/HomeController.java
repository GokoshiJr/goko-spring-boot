package com.goko.hibernate.basic.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

        System.out.println(personRepository.findAllLikeDirection("A"));

        var persons = (List<Person>) personRepository.findAll();
        Map<String, Object> res = new HashMap<>();
        res.put("persons", persons);
        res.put("date", new Date().toString());
        return ResponseEntity.ok(res);
    }
}
