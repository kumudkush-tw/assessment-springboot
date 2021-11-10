package com.example.assesstodo.assessmenttodo.models;

import javax.persistence.*;

@Entity
@Table(name="persons")
public class Todo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer age;

    public Todo() {
    }

    public Todo(Long id, String name, String description, Integer age) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAge() {
        return age;
    }
}
