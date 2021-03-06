package com.thoughtworks.todolist.controller;

import com.thoughtworks.todolist.dto.TodoListRequest;
import com.thoughtworks.todolist.entity.TodoListItem;
import com.thoughtworks.todolist.exception.TodoListAddErrorException;
import com.thoughtworks.todolist.exception.TodoListNotFoundException;
import com.thoughtworks.todolist.exception.TodoListUpdateErrorException;
import com.thoughtworks.todolist.service.TodoListService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/todos")
public class TodoListController {
    private final TodoListService todoListService;

    public TodoListController(TodoListService todolistService) {
        this.todoListService = todolistService;
    }

    @GetMapping()
    public List<TodoListItem> getAllTodoList() {
        return todoListService.getAllTodoList();
    }

    @PostMapping()
    public TodoListItem addTodoList(@RequestBody @Valid TodoListRequest todoListRequest) throws TodoListAddErrorException {
        return todoListService.addTodoList(todoListRequest);
    }

    @PutMapping("/{id}")
    public TodoListItem updateTodoListItem(@PathVariable Integer id,
                                           @RequestBody TodoListItem todoListItem) throws TodoListUpdateErrorException {
        return todoListService.updateTodoListItem(id,todoListItem);
    }

    @DeleteMapping("/{id}")
    public String deleteTodoListItem(@PathVariable Integer id)throws TodoListNotFoundException {
        return todoListService.deleteTodoListItem(id);
    }

}
