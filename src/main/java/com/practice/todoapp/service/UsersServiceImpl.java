package com.practice.todoapp.service;

import com.practice.todoapp.exception.UserNotFoundException;
import com.practice.todoapp.model.CategorizationEnum;
import com.practice.todoapp.model.Users;
import com.practice.todoapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@Slf4j
public class UsersServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Users> getUsers() {
        List<Users> users = userRepository.findAll(); // list o
        if (!ObjectUtils.isEmpty(users)) {
            return users;
        } else {
            // Log.info("List users is empty.");
            throw new IllegalArgumentException("users are not available in the system.");
        }
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
        /* if(CategorizationEnum.parse(user.getCategorization()) == null) {
            throw new IllegalArgumentException("Not supporting the given categorization: " + user.getCategorization());
        } */
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Users updateUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Object findByUserId(Integer id) {
        return userRepository.findByUserId(id);
    }
}
