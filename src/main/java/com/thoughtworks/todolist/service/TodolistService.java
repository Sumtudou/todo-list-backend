package com.thoughtworks.todolist.service;

import com.thoughtworks.todolist.entity.TodoList;

import java.util.List;

public interface TodolistService {
    List<TodoList> getAllTodoList();
}
