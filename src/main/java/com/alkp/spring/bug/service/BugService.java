package com.alkp.spring.bug.service;

import com.alkp.spring.base.exception.ResourceNotFountException;
import com.alkp.spring.bug.entity.BugEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BugService {
    static List<BugEntity> bugStorage = new ArrayList<>();

    public BugService() {
        fillStorage();
    }

    public void fillStorage() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            BugEntity bug = new BugEntity();
            bug.setId(i);
            bug.setTitle("Bug #" + random.nextInt(100, 999));
            bug.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
            bugStorage.add(bug);
        }
    }

    public List<BugEntity> all() {
        return bugStorage;
    }

    public Optional<BugEntity> byId(int id) {
        return bugStorage.stream().filter(bug -> bug.getId() == id).findFirst();
    }

    public BugEntity create(String title, String description) {
        BugEntity bug = new BugEntity();
        bug.setId(bugStorage.size());
        bug.setTitle(title);
        bug.setDescription(description);
        bugStorage.add(bug);
        return bug;
    }

    public Optional<BugEntity> update(BugEntity bug) {
        BugEntity oldBugEntity = byId(bug.getId()).orElseThrow();
        oldBugEntity.setTitle(bug.getTitle());
        oldBugEntity.setDescription(bug.getDescription());
        return Optional.of(oldBugEntity);
    }
}
