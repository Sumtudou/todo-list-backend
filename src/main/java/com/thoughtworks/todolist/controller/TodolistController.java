package com.thoughtworks.todolist.controller;

import com.thoughtworks.todolist.entity.Employee;
import com.thoughtworks.todolist.entity.Todolist;
import com.thoughtworks.todolist.service.TodolistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/todos")
public class TodolistController {
    private final TodolistService todolistService;

    public TodolistController(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    @GetMapping()
    public List<Todolist> getAllTodoList() {
        return todolistService.getAllTodoList();
    }



}
