package com.practice.todoapp.service;

import com.practice.todoapp.model.ToDoItem;

import java.util.List;

public interface ToDoItemService {
  public ToDoItem getToDoItemById(Integer id);

  public ToDoItem createToDoItem(ToDoItem toDoItem);

  public ToDoItem updateToDoItem(ToDoItem toDoItem);

  public void deleteToDoItem(Integer id);
}
