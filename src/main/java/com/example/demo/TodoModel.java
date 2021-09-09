package com.example.demo;

import org.springframework.data.annotation.Id;

public class TodoModel {

    @Id
    private String id;

    private String description;

    public TodoModel(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
