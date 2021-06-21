package com.practice.todoapp.controller;

import com.practice.todoapp.exception.ToDoItemBadRequest;
import com.practice.todoapp.exception.ToDoItemNotFoundException;
import com.practice.todoapp.model.ToDoItem;
import com.practice.todoapp.service.ToDoItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/ToDoItem")
@Slf4j
public class ToDoItemController {
    @Autowired
    ToDoItemService toDoItemService;

    @GetMapping(value="/{id}")
    public ResponseEntity<ToDoItem> getToDoItemById(@PathVariable("id") Integer userId) {
        return new ResponseEntity<>(toDoItemService.getToDoItemById(userId),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<ToDoItem> getToDoItemByIdParam(@RequestParam("id") Integer userId) {
        return new ResponseEntity<>(toDoItemService.getToDoItemById(userId),HttpStatus.OK);
    }

    @GetMapping(value="/allItems")
    public ResponseEntity<List<ToDoItem>> getAllItems(){
        return new ResponseEntity<>(toDoItemService.getAllItems(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ToDoItem> createToDoItem(@RequestBody ToDoItem todoItem) {
        try {
            if (!StringUtils.hasText(todoItem.getImageUrl())) {
                throw new ToDoItemBadRequest("Image url should be required to create a todo item.");
            }
        } catch (Exception e) {
            log.error("Image url should be required to create a todo item. ", e.getLocalizedMessage());
            throw new ToDoItemBadRequest("Image url should be required to create a todo item.");
        }
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
    /*
    @ExceptionHandler(value=ToDoItemNotFoundException.class)
    public ResponseEntity<Object> exception(ToDoItemNotFoundException exception){
        return new ResponseEntity<>("To do item not found", HttpStatus.NOT_FOUND);
    }

     */
}
