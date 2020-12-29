package com.practice.todoapp.service;

import com.practice.todoapp.model.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public List<Users> getUsers();

    public Users getUserById(Long id);

    public Users createUser(Users user);

    public ResponseEntity deleteUser(Long id);

    public Users updateUser(Users user);

    public List<Users> findByUserId(Integer id);
}
