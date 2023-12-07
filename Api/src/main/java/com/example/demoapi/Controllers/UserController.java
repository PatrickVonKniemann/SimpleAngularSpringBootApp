package com.example.demoapi.Controllers;

import com.example.demoapi.Models.Dtos.*;
import com.example.demoapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<AppUserReadDTO>> getAllUsers() {
        List<AppUserReadDTO> users = userService.getAllItems();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserReadDTO> getUser(@PathVariable Long id) {
        return userService.getItem(id)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AppUserReadDTO> addUser(@RequestBody AppUserCreateDTO appUserCreateDTO) {
        AppUserReadDTO newUser = userService.addItem(appUserCreateDTO);
        return ResponseEntity.ok().body(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUserReadDTO> updateUser(@PathVariable Long id, @RequestBody AppUserUpdateDTO appUserUpdateDTO) {
        AppUserReadDTO updatedUser = userService.updateUser(id, appUserUpdateDTO);
        return ResponseEntity.ok().body(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) throws Exception {
        userService.authenticate(loginRequest);
        return ResponseEntity.ok().build();
    }
}
