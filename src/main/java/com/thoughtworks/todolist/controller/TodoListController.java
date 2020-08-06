package com.thoughtworks.todolist.controller;

import com.thoughtworks.todolist.dto.TodoListRequest;
import com.thoughtworks.todolist.entity.TodoListItem;
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
    public TodoListItem addTodoList(@RequestBody @Valid TodoListRequest todoListRequest){
        return todoListService.addTodoList(todoListRequest);
    }

    @PutMapping("/{id}")
    public TodoListItem updateTodoListItem(@PathVariable Integer id,
                                           @RequestBody @Valid TodoListRequest todoListRequest){
        return todoListService.updateTodoListItem(id,todoListRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoListItem(@PathVariable Integer id){
        todoListService.deleteTodoListItem(id);
    }

}
