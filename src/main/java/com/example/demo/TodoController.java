package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<TodoModel> getAllTodos(){
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public TodoModel addTodo(@RequestBody TodoModel todo){
        return repository.save(todo);
    }
}
