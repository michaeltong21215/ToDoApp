package com.practice.todoapp.service;

import com.practice.todoapp.exception.ToDoItemNotFoundException;
import com.practice.todoapp.model.ToDoItem;
import com.practice.todoapp.repository.ToDoItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ToDoItemServiceImpl implements ToDoItemService {

    @Autowired
    ToDoItemRepository toDoItemRepository;

    @Override
    public ToDoItem getToDoItemById(Integer id) {
        try {
            Optional<ToDoItem> toDoItem = toDoItemRepository.findById(id);
            if(toDoItem.isPresent()){
                log.debug("Item is received");
                return toDoItem.get();
            } else {
                log.error(MessageFormat.format("To do Item with id {0} is not found", id));
               throw new ToDoItemNotFoundException(MessageFormat.format("To do Item with id {0} is not found", id));
            }
        } catch (Exception e) {
            throw new ToDoItemNotFoundException(MessageFormat.format("Response Status: To do Item with id {0} is not found", id));
        }
    }

    @Override
    public List<ToDoItem> getAllItems() {
        return toDoItemRepository.findAll();
    }

    @Override
    public ToDoItem createToDoItem(ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }

    @Override
    public ToDoItem updateToDoItem(ToDoItem toDoItem) {
        return toDoItemRepository.save(toDoItem);
    }

    @Override
    public void deleteToDoItem(Integer id) {
        toDoItemRepository.deleteById(id);
    }
}
