package com.practice.todoapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="steps")
@Data
public class Steps extends Auditable<String>{
    @Id
    @Column(name="stepid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stepid;

    @Column(name="stepOrder", nullable = false)
    private Integer steporder;

    @Column(name="imageurl", nullable = false)
    private String imageurl;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="stepname", nullable = false)
    private String stepname;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ToDoItem todoitem;
}
