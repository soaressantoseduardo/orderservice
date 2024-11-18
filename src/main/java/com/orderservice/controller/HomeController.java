package com.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Order Service API is running!";
    }
    
    @GetMapping("/actuator/hello")
    public String hello() {
        return "Hello from Actuator!";
    }
}