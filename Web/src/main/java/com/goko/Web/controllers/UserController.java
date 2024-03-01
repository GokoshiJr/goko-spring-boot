package com.goko.Web.controllers;

import com.goko.Web.models.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class UserController {

    @ModelAttribute("users")
    public ArrayList<UserModel> getUsers() {
        ArrayList<UserModel> users = new ArrayList<>();
        users.add(new UserModel("Julio", "Gonzalez", "julio@gmail.com"));
        users.add(new UserModel("John", "Doe"));
        users.add(new UserModel("Foo", "Bar"));
        users.add(new UserModel("Epa", "Alex"));
        users.add(new UserModel("Tigre", "De bengala", "tigre@gmail.com"));
        return users;
    }

    @ModelAttribute("info")
    public HashMap<String, String> getInfo() {
        HashMap<String, String> info = new HashMap<>();
        info.put("title", "Web");
        info.put("subtitle", "Learning Spring Boot 3");
        return info;
    }
    @GetMapping("/list")
    public String list(ModelMap model) {
        return "list";
    }

    @GetMapping("/details")
    public String details(Model model) {
        UserModel user = new UserModel("Julio", "Gonzalez");
        model.addAttribute("name", "Goko");
        model.addAttribute("age", 23);
        model.addAttribute("user", user);
        return "details";
    }


}
