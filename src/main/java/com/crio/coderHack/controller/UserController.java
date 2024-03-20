package com.crio.coderHack.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.coderHack.dto.UserDTO;
import com.crio.coderHack.dto.UserScoreDTO;
import com.crio.coderHack.service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllusers()
    {
        return ResponseEntity.ok().body(userService.findAll());
    }

     @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@NonNull @PathVariable String id) {
        Optional<UserDTO> user = userService.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> putScoreByUserId(@Validated @RequestBody UserScoreDTO userScoreDTO)
    {
        Optional<UserDTO> user = userService.putScoreByUserId(userScoreDTO);
        if (user.isPresent()) {
            return ResponseEntity.accepted().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserId(@NonNull @PathVariable String id)
    {
        userService.deleteUserById(id);
        return ResponseEntity.ok().body("Deleted User Succesfully");
    }


}
