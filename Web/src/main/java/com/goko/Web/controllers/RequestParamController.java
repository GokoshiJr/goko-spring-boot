package com.goko.Web.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goko.Web.models.dtos.ParamDto;


@RestController
@RequestMapping("api/params")
public class RequestParamController {

    @GetMapping("/req")
    public ParamDto req(HttpServletRequest req) {
        int code = 0;
        try {
            code = Integer.parseInt(req.getParameter("code"));
        } catch (Exception ignored) { }
        return new ParamDto(
                req.getParameter("message"),
                code
        );
    }

    @GetMapping("/bar")
    public ParamDto bar(
            @RequestParam String text,
            @RequestParam Integer code
    ) {
        return new ParamDto(text, code);
    }

    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required=false, defaultValue="hello world 2") String message) {
        return new ParamDto(message);
    }

}
