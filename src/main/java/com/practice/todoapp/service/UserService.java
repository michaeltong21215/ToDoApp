package com.practice.todoapp.service;

import com.practice.todoapp.model.Users;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public List<Users> getUsers();

    public Users getUserById(Long id);

    public Users createUser(Users user);

    public void deleteUser(Long id);

    public Users updateUser(Users user);

    public Object findByUserId(Integer id);
}
