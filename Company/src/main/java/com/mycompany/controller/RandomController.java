package com.mycompany.controller;

import com.mycompany.model.Random;
import com.mycompany.service.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/company/api/random")
public class RandomController {

    @Autowired
    RandomService randomService;

    @GetMapping("/health")
    public String state() {
        return "Success";
    }

    @GetMapping("/getLucky")
    public Random getLucky(){
        return randomService.getLucky();
    }
}
