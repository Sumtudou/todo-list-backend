package com.thoughtworks.todolist.service;

import com.thoughtworks.todolist.dto.TodoListRequest;
import com.thoughtworks.todolist.entity.TodoListItem;
import com.thoughtworks.todolist.exception.TodoListAddErrorException;
import com.thoughtworks.todolist.exception.TodoListNotFoundException;
import com.thoughtworks.todolist.exception.TodoListUpdateErrorException;

import java.util.List;

public interface TodoListService {
    List<TodoListItem> getAllTodoList();

    TodoListItem addTodoList(TodoListRequest todoListRequest) throws TodoListAddErrorException;

    TodoListItem updateTodoListItem(Integer id, TodoListItem todoListItem) throws TodoListUpdateErrorException;

    String deleteTodoListItem(Integer id) throws TodoListNotFoundException;
}
