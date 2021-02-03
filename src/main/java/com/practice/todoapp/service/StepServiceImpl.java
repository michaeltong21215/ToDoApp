package com.practice.todoapp.service;

import com.practice.todoapp.model.Steps;
import com.practice.todoapp.repository.StepRepository;
import com.practice.todoapp.repository.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepServiceImpl implements StepService{

    @Autowired
    StepRepository stepRepository;

    @Override
    public List<Steps> getSteps() {
        return stepRepository.findAll();
    }

    @Override
    public Steps getStepById(Integer id) {
        return stepRepository.findById(id).get();
    }

    @Override
    public Steps createStep(Steps step) {
        return stepRepository.save(step);
    }

    @Override
    public Steps updateStep(Steps step) {
        return stepRepository.save(step);
    }

    @Override
    public void deleteStep(Integer id) {
        stepRepository.deleteById(id);
    }
}
