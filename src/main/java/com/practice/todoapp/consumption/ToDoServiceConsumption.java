package com.practice.todoapp.consumption;

import com.practice.todoapp.model.ToDoItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1/ToDoItemConsumption")
@Slf4j
public class ToDoServiceConsumption {
    @GetMapping
    public ResponseEntity testService(){
        RestTemplate restTemplate = new RestTemplate();
        ToDoItem toDoItem = restTemplate.getForObject("http://localhost:8080/v1/ToDoItem/1", ToDoItem.class);
        log.info("received response: {}", toDoItem.toString());
        return new ResponseEntity(toDoItem, HttpStatus.OK);
    }
}
