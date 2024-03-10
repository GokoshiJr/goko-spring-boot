package com.goko.Aspects.controllers;

import com.goko.Aspects.models.Greeting;
import com.goko.Aspects.services.HomeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HomeController {

    HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/home")
    public ResponseEntity<?> home() {
        Map<String, String> res = new HashMap<>();
        res.put("message", "hello world");
        res.put("date", new Date().toString());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/greeting")
    public ResponseEntity<?> greeting(@RequestBody Greeting greeting) {
        Map<String, String> res = new HashMap<>();
        res.put("message", homeService.getGreeting(greeting.getUser(), greeting.getPhrase()));
        res.put("date", new Date().toString());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
