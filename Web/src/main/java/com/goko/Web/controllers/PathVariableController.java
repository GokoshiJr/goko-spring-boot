package com.goko.Web.controllers;

import com.goko.Web.models.UserModel;
import com.goko.Web.models.dtos.ParamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${gokoconfig.username}")
    private String username;
    @Value("${gokoconfig.listOfValues}")
    private String[] listOfValues;

    @Value("#{'${gokoconfig.listOfValues}'.toUpperCase().split(',')}")
    private List<String> list;

    @Value("#{${gokoconfig.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${gokoconfig.valuesMap}.product}")
    private String product;

    @Autowired
    private Environment environment;

    @GetMapping("/config")
    public Map<String, Object> config() {
        Map<String, Object> res = new HashMap<>();
        res.put("username", this.username);
        res.put("username_env", this.environment.getProperty("gokoconfig.username"));
        res.put("listOfValues", this.listOfValues);
        res.put("list", this.list);
        res.put("valuesMap", this.valuesMap);
        res.put("product", this.product);
        return res;
    }

    @PostMapping("/create")
    public UserModel create(@RequestBody UserModel userModel) {
        userModel.setName(userModel.getName().toUpperCase());
        return userModel;
    }
    @GetMapping("/mix/{product}/{id}")
    public HashMap<String, Object> mix(
            @PathVariable String product,
            @PathVariable Integer id
    ) {
        HashMap<String, Object> res = new HashMap<>();
        res.put("product", product);
        res.put("id", id);
        return res;
    }

    @GetMapping("/buzz/{message}")
    public ParamDto buzz(@PathVariable String message) {
        return new ParamDto(message);
    }
}
