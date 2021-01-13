package com.practice.todoapp.service;

import com.practice.todoapp.model.ToDoItem;
import com.practice.todoapp.repository.ToDoItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ToDoItemServiceImpl implements ToDoItemService {

    @Autowired
    ToDoItemRepository toDoItemRepository;

    @Override
    public ToDoItem getToDoItemById(Integer id) {
        return toDoItemRepository.findById(id).get();
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
