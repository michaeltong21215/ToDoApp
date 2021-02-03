package com.practice.todoapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="todoitem")
@Data
public class ToDoItem extends Auditable<String>{
    @Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="imageurl", nullable = false)
    private String imageUrl;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="role", nullable = false)
    private String role;

    @Column(name="status", nullable = false)
    private String status;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Users users;

}
