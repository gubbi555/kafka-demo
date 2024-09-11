package com.codedecode.KafkaDemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  // This annotation marks the class as a Spring REST controller
public class HomeController {

    // This method handles GET requests to the root URL ("/")
    @GetMapping("/")
    public String home() {
        return "Welcome to the Kafka Demo Application!";
    }
}
