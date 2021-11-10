package com.example.assesstodo.assessmenttodo.controllers;

import com.example.assesstodo.assessmenttodo.models.Todo;
import com.example.assesstodo.assessmenttodo.models.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/person")
public class TodoController {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/person")
    Iterable<Todo> getPersons(){
        return todoRepository.findAll();
    }

    @GetMapping("/{id}")
    Optional<Todo> getPersonById(@PathVariable Long id){
        return todoRepository.findById(id);
    }

    @PostMapping("/person")
    Todo postPersonData(@RequestBody Todo todo){
        return todoRepository.save(todo);
    }


    @DeleteMapping("/{id}")
    void DeletePersonData(@PathVariable Long id){
        todoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<Todo> putPersonData(@PathVariable Long id, @RequestBody Todo todo){
        return(!todoRepository.existsById(id))
                ? new ResponseEntity<>(todoRepository.save(todo),
                HttpStatus.CREATED)
                : new ResponseEntity<>(todoRepository.save(todo), HttpStatus.OK);
    }




}
