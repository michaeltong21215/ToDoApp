package com.practice.todoapp.service;

import com.practice.todoapp.exception.UserNotFoundException;
import com.practice.todoapp.model.Users;
import com.practice.todoapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get();
        }
        else {
            throw new UserNotFoundException(String.format("User is not available: %s, ", id));
        }
    }

    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity deleteUser(Long id) {
        userRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public List<Users> findByUserId(Integer id) {
        return userRepository.findByUserId(id);
    }
}
