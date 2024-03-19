package com.crio.coderHack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.coderHack.dto.UserDTO;
import com.crio.coderHack.service.UserService;

import com.crio.coderHack.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody User user)
    {
        return ResponseEntity.ok().body(userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllusers()
    {
        return ResponseEntity.ok().body(userService.findAll());
    }

}
