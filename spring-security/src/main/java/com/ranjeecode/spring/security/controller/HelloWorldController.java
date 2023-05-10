package com.ranjeecode.spring.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping({ "/hello" })
    public String helloWord() {
        return "Hello World";
    }

}
