package com.practice.todoapp.service;

import com.practice.todoapp.model.Steps;

import java.util.List;

public interface StepService {

    public List<Steps> getSteps();

    public Steps getStepById(Integer id);

    public Steps createStep(Steps step);

    public Steps updateStep(Steps step);

    public void deleteStep(Integer id);
}
