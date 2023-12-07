package com.example.demoapi.Controllers;

import com.example.demoapi.Service.UserService;
import com.example.demoapi.Models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService simpleService;

    @Autowired
    public UserController(UserService simpleService) {
        this.simpleService = simpleService;
    }

    @GetMapping
    public List<AppUser> getItems() {
        return simpleService.getAllItems();
    }

    @GetMapping("/{index}")
    public Optional<AppUser> getItem(@PathVariable Long index) {
        return simpleService.getItem(index);
    }

    @PostMapping
    public void addItem(@RequestBody AppUser item) {
        simpleService.addItem(item);
    }

    @PutMapping("/{index}")
    public void updateItem(@PathVariable Long index, @RequestBody AppUser newItem) {
        simpleService.updateUser(index, newItem);
    }

    @DeleteMapping("/{index}")
    public void deleteItem(@PathVariable Long index) {
        simpleService.deleteUser(index);
    }
}