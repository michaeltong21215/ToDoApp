package com.practice.todoapp.controller;

import com.practice.todoapp.model.Users;
import com.practice.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<Users> getUsers(){
        return userService.getUsers();
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(userService.findByUserId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody Users user) {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
