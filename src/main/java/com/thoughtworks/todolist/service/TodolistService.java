package com.thoughtworks.todolist.service;

import com.thoughtworks.todolist.dto.TodoListRequest;
import com.thoughtworks.todolist.entity.TodoListItem;

import java.util.List;

public interface TodolistService {
    List<TodoListItem> getAllTodoList();

    TodoListItem addTodoList(TodoListRequest todoListRequest);
}
