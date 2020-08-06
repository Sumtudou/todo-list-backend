package com.thoughtworks.todolist.service;

import com.thoughtworks.todolist.dto.TodoListRequest;
import com.thoughtworks.todolist.entity.TodoListItem;

import java.util.List;

public interface TodoListService {
    List<TodoListItem> getAllTodoList();

    TodoListItem addTodoList(TodoListRequest todoListRequest);

    TodoListItem updateTodoListItem(Integer id, TodoListRequest todoListRequest);

    void deleteTodoListItem(Integer id);
}
