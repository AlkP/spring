package com.alkp.spring.bug.controller;

import com.alkp.spring.base.exception.ResourceNotFountException;
import com.alkp.spring.bug.entity.BugEntity;
import com.alkp.spring.bug.service.BugService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping("/api/v1/bug")
    public BugEntity create(@RequestBody BugEntity request) {
        return bugService.create(request.getTitle(), request.getDescription());
    }

    @PutMapping("/api/v1/bug/{id}")
    public BugEntity update(@PathVariable Integer id, @RequestBody BugEntity request) {
        return bugService.update(request).orElseThrow(ResourceNotFountException::new);
    }

    @DeleteMapping("/api/v1/bug/{id}")
    public Boolean delete(@PathVariable("id") Integer id) {
        return bugService.delete(id);
    }

    @PatchMapping("/api/v1/bug/{id}")
    public BugEntity update_part(@PathVariable Integer id, @RequestBody Map<String, String> fields) {
        return bugService.updatePart(id, fields).orElseThrow(ResourceNotFountException::new);
    }
}
