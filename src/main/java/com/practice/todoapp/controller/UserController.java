package com.practice.todoapp.controller;

import com.practice.todoapp.model.Users;
import com.practice.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Users> getUserById(@PathVariable("id") Integer id) {
        return userService.findByUserId(id);
    }

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return userService.createUser(user);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        return userService.deleteUser(id);
    }

    @PutMapping
    public Users updateUser(@RequestBody Users user) {
        return userService.updateUser(user);
    }
}
