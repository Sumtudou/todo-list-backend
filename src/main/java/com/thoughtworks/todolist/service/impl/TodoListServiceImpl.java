package com.thoughtworks.todolist.service.impl;

import com.thoughtworks.todolist.entity.TodoList;
import com.thoughtworks.todolist.repository.TodoListRepository;
import com.thoughtworks.todolist.service.TodolistService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoListServiceImpl implements TodolistService {
    private final TodoListRepository todolistRepository;
    public TodoListServiceImpl(TodoListRepository todolistRepository){
        this.todolistRepository = todolistRepository;
    }
    @Override
    public List<TodoList> getAllTodoList() {
        return todolistRepository.findAll();
    }
}
