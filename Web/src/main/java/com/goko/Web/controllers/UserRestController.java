package com.goko.Web.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.goko.Web.models.UserModel;
import com.goko.Web.models.dtos.UserDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController // Une las notaciones @Controller y @RequestBody
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/users")
    public HashMap<String, Object> getUsers() {
        ArrayList<UserModel> users = new ArrayList<>();
        users.add(new UserModel("Julio", "Gonzalez"));
        users.add(new UserModel("John", "Doe"));
        users.add(new UserModel("Foo", "Bar"));
        HashMap<String, Object> res = new HashMap<>();
        res.put("data", users);
        return res;
    }
    @GetMapping("/user-dto")
    public UserDto detailsDto() {
        return new UserDto("epa Alex", new UserModel("Julio", "Gonzalez"));
    }

    @GetMapping("/user-map")
    public Map<String, Object> detailsMap() {
        Map<String, Object> res = new HashMap<>();
        res.put("user", new UserModel("Julio", "Gonzalez"));
        return res;
    }
}
