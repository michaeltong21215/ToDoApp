package com.practice.todoapp.controller;

import com.practice.todoapp.model.Steps;
import com.practice.todoapp.model.Users;
import com.practice.todoapp.service.StepService;
import com.practice.todoapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/steps")
public class StepsController {

    @Autowired
    StepService stepService;

    @GetMapping
    public List<Steps> getSteps(){
        return stepService.getSteps();
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Object> getStepById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(stepService.getStepById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Steps> createStep(@RequestBody Steps step) {
        return new ResponseEntity<>(stepService.createStep(step), HttpStatus.CREATED);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity deleteStep(@PathVariable("id") Integer id) {
        stepService.deleteStep(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity updateStep(@RequestBody Steps step) {
        stepService.updateStep(step);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
