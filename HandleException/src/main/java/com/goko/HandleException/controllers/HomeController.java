package com.goko.HandleException.controllers;

import com.goko.HandleException.models.domain.User;
import com.goko.HandleException.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/show/{id}")
    public Optional<User> getUserById(@PathVariable(name = "id") Long id) {
        return this.userService.findById(id);
    }

    @GetMapping("/show")
    public List<User> getUsers() {
        return this.userService.findAll();
    }

    @GetMapping({"/", ""})
    public String index() {
        /*int value = 100 / 0;*/
        int value = Integer.parseInt("10x");
        System.out.println(value);
        return "index";
    }


}
