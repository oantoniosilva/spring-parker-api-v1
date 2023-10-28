package com.antoniosilva.spring.parker.api.controllers;

import com.antoniosilva.spring.parker.api.entities.User;
import com.antoniosilva.spring.parker.api.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        var userPost = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userPost);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updatePassword(@PathVariable Long id, @RequestBody User user) {
        var newPassword = userService.changePassword(id, user.getPassword());
        return ResponseEntity.ok(newPassword);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.listAll();
        return ResponseEntity.ok(users);
    }
}
