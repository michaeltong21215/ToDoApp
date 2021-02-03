package com.practice.todoapp.repository;

import com.practice.todoapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("SELECT userId, firstName, lastName from Users where userId = ?1")
    public Object findByUserId(Integer id);
}
