package com.thoughtworks.todolist.service.impl;

import com.thoughtworks.todolist.entity.Todolist;
import com.thoughtworks.todolist.repository.TodolistRepository;
import com.thoughtworks.todolist.service.TodolistService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodolistServiceImpl implements TodolistService {
    private final TodolistRepository todolistRepository;
    public TodolistServiceImpl(TodolistRepository todolistRepository){
        this.todolistRepository = todolistRepository;
    }
    @Override
    public List<Todolist> getAllTodoList() {
        return todolistRepository.findAll();
    }
}
