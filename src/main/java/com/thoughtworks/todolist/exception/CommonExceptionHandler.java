package com.thoughtworks.todolist.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CommonExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public List<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        return exception.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField()+":"+e.getDefaultMessage()).collect(Collectors.toList());
    }

    @ExceptionHandler(TodoListNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    String todoListNotFoundException(){
        return "This item is not found in DB.";
    }

    @ExceptionHandler(TodoListAddErrorException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    String todoListAddErrorException(){
        return "Add todoList item failed.";
    }

    @ExceptionHandler(TodoListUpdateErrorException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    String todoListUpdateErrorException(){
        return "Update todoList item failed.";
    }

}
