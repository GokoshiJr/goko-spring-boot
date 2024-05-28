package com.goko.Interceptores.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/home")
    public Map<String, String> home() {
        Map<String, String> res = new HashMap<>();
        res.put("route", "home");
        return res;
    }

    @GetMapping("/foo")
    public Map<String, String> foo() {
        Map<String, String> res = new HashMap<>();
        res.put("route", "foo");
        return res;
    }

    @GetMapping("/bar")
    public Map<String, String> bar() {
        Map<String, String> res = new HashMap<>();
        res.put("route", "bar");
        return res;
    }
}
