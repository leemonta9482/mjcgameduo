package com.javaproject.mjcgameduo.controller;

import com.javaproject.mjcgameduo.domain.User;
import com.javaproject.mjcgameduo.dto.AddUserRequest;
import com.javaproject.mjcgameduo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/user/create")
    public ResponseEntity<User> saveArticle(@RequestBody AddUserRequest request) {
        User savedRequest =  userService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRequest);
    }
}