package com.practice.todoapp.controller;

import com.practice.todoapp.model.ToDoItem;
import com.practice.todoapp.service.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ToDoItem")
public class ToDoItemController {
    @Autowired
    ToDoItemService toDoItemService;

    @GetMapping(value="/{id}")
    public ResponseEntity<ToDoItem> getToDoItemById(@PathVariable("id") Integer userId) {
        return new ResponseEntity<>(toDoItemService.getToDoItemById(userId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ToDoItem> createToDoItem(@RequestBody ToDoItem todoItem) {
        return new ResponseEntity<ToDoItem>(toDoItemService.createToDoItem(todoItem), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ToDoItem> updateToDoItem(@RequestBody ToDoItem toDoItem) {
        return new ResponseEntity<ToDoItem>(toDoItemService.updateToDoItem(toDoItem), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<ToDoItem> deleteToDoItem(@PathVariable("id") Integer toDoId) {
        toDoItemService.deleteToDoItem(toDoId);
        return new ResponseEntity<ToDoItem>(HttpStatus.NO_CONTENT);
    }
}