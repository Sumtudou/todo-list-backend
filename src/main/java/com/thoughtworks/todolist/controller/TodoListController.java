package com.thoughtworks.todolist.controller;

import com.thoughtworks.todolist.dto.TodoListRequest;
import com.thoughtworks.todolist.entity.TodoListItem;
import com.thoughtworks.todolist.service.TodolistService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public List<TodoListItem> getAllTodoList() {
        return todolistService.getAllTodoList();
    }

    @PostMapping()
    public TodoListItem addTodoList(@RequestBody @Valid TodoListRequest todoListRequest){
        return todolistService.addTodoList(todoListRequest);
    }

}
