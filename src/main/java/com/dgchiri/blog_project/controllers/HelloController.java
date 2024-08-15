package com.dgchiri.blog_project.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello";
    }
    

}
