package com.practice.todoapp.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ToDoItem")
@Data
public class ToDoItem extends Auditable<String>{
    @Id
    @Column(name="Id", nullable = false)
    private Integer id;

    @Column(name="userId", nullable = false)
    private String userId;

    @Column(name="imageUrl", nullable = false)
    private String imageUrl;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="role", nullable = false)
    private String role;

    @Column(name="status", nullable = false)
    private String status;

}
