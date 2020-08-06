package com.thoughtworks.todolist.service;

import com.thoughtworks.todolist.entity.Todolist;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodolistService {
    List<Todolist> getAllTodoList();
}
