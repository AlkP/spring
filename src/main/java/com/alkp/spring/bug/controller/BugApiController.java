package com.alkp.spring.bug.controller;

import com.alkp.spring.base.exception.ResourceNotFountException;
import com.alkp.spring.bug.entity.BugEntity;
import com.alkp.spring.bug.service.BugService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BugApiController {
    private final BugService bugService;

    public BugApiController(BugService bugService) {
        this.bugService = bugService;
    }

    @GetMapping("/")
    public String ok() {
        return "ok";
    }

    @GetMapping("/api/v1/bug")
    public List<BugEntity> all() {
        return bugService.all();
    }

    @GetMapping("/api/v1/bug/{id}")
    public BugEntity byId(@PathVariable Integer id) {
        return bugService.byId(id).orElseThrow(ResourceNotFountException::new);
    }
}
