package com.goko.TimeInterceptor.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/home")
    public Map<String, String> home() {
        Map<String, String> res = new HashMap<>();
        res.put("route", "home");
        res.put("time", new Date().toString());
        return res;
    }

    @GetMapping("/foo")
    public Map<String, String> foo(HttpServletRequest request) {
        Map<String, String> res = new HashMap<>();
        res.put("route", "foo");
        res.put("time", new Date().toString());
        res.put("msg", request.getAttribute("msg").toString());
        return res;
    }

    @GetMapping("/bar")
    public ResponseEntity<?> bar(HttpServletRequest request) {
        Map<String, String> res = new HashMap<>();
        res.put("route", "bar");
        res.put("time", new Date().toString());
        res.put("msg", request.getAttribute("msg").toString());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
