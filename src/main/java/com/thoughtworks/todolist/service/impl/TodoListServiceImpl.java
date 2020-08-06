package com.thoughtworks.todolist.service.impl;

import com.thoughtworks.todolist.dto.TodoListRequest;
import com.thoughtworks.todolist.entity.TodoListItem;
import com.thoughtworks.todolist.repository.TodoListRepository;
import com.thoughtworks.todolist.service.TodoListService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoListServiceImpl implements TodoListService {
    private final TodoListRepository todolistRepository;
    public TodoListServiceImpl(TodoListRepository todolistRepository){
        this.todolistRepository = todolistRepository;
    }
    @Override
    public List<TodoListItem> getAllTodoList() {
        return todolistRepository.findAll();
    }

    @Override
    public TodoListItem addTodoList(TodoListRequest todoListRequest) {
        TodoListItem todoListItem = new TodoListItem();
        BeanUtils.copyProperties(todoListRequest,todoListItem);
        return todolistRepository.save(todoListItem);
    }

    @Override
    public TodoListItem updateTodoListItem(Integer id, TodoListRequest todoListRequest) {
        TodoListItem todoListItem = new TodoListItem();
        BeanUtils.copyProperties(todoListRequest,todoListItem);
        todoListItem.setId(id);
        return todolistRepository.save(todoListItem);
    }
}
