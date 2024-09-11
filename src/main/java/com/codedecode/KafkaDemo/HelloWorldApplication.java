package com.codedecode.KafkaDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldApplication {

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }
}

