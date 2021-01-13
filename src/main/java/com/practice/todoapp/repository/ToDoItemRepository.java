package com.practice.todoapp.repository;

import com.practice.todoapp.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Integer> {

}
