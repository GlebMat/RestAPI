package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.services.Services;

@RestController
@RequestMapping("/TestJobMG")
public class Controller {
    private final Services services;

    @Autowired
    public Controller(Services services) {
        this.services = services;
    }

    @GetMapping("/charInStr/{Strings}")
    public StringBuilder printCountCharInStr(@PathVariable("Strings") String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(services.countCharInStr(str));
        return sb;
    }

}
