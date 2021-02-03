package com.practice.todoapp.repository;

import com.practice.todoapp.model.Steps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository<Steps, Integer> {
}
