package com.antoniosilva.spring.parker.api.controllers;

import com.antoniosilva.spring.parker.api.entities.User;
import com.antoniosilva.spring.parker.api.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
