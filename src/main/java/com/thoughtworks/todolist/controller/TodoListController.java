package com.thoughtworks.todolist.controller;

import com.thoughtworks.todolist.entity.TodoList;
import com.thoughtworks.todolist.service.TodolistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/todos")
public class TodoListController {
    private final TodolistService todolistService;

    public TodoListController(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    @GetMapping()
    public List<TodoList> getAllTodoList() {
        return todolistService.getAllTodoList();
    }



}
