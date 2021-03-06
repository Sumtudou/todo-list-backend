package com.thoughtworks.todolist.service.impl;

import com.thoughtworks.todolist.dto.TodoListRequest;
import com.thoughtworks.todolist.entity.TodoListItem;
import com.thoughtworks.todolist.exception.TodoListAddErrorException;
import com.thoughtworks.todolist.exception.TodoListNotFoundException;
import com.thoughtworks.todolist.exception.TodoListUpdateErrorException;
import com.thoughtworks.todolist.repository.TodoListRepository;
import com.thoughtworks.todolist.service.TodoListService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService {
    private final TodoListRepository todolistRepository;

    public TodoListServiceImpl(TodoListRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public List<TodoListItem> getAllTodoList() {
        return todolistRepository.findAll();
    }

    @Override
    public TodoListItem addTodoList(TodoListRequest todoListRequest) throws TodoListAddErrorException {
        TodoListItem todoListItem = new TodoListItem();
        BeanUtils.copyProperties(todoListRequest, todoListItem);
        TodoListItem savedItem = todolistRepository.save(todoListItem);
        return todolistRepository.findById(savedItem.getId()).orElseThrow(TodoListAddErrorException::new);
    }

    @Override
    public TodoListItem updateTodoListItem(Integer id, TodoListItem todoListItem) throws TodoListUpdateErrorException {
        TodoListItem originItem = new TodoListItem();
        BeanUtils.copyProperties(todolistRepository.findById(id).orElseThrow(TodoListUpdateErrorException::new), originItem);
        TodoListItem savedItem = todolistRepository.save(todoListItem);
        if (originItem.equals(savedItem)) {
            throw new TodoListUpdateErrorException();
        }
        return savedItem;
    }

    @Override
    public String deleteTodoListItem(Integer id) throws TodoListNotFoundException {
        todolistRepository.findById(id).orElseThrow(TodoListNotFoundException::new);
        todolistRepository.deleteById(id);
        return "success delete";
    }
}
