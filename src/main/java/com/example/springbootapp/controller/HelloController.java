package com.example.springbootapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloController {

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Another change to check",
                HttpStatus.OK);
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> hello(@PathVariable("name") String name) {
        return new ResponseEntity<>("Hello " + name + "!", HttpStatus.OK);
    }
}
