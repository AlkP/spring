package com.alkp.spring.bug.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BugApiController {

    @GetMapping("/")
    public String ok() {
        return "ok";
    }

}
