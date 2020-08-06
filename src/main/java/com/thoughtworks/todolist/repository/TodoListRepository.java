package com.thoughtworks.todolist.repository;

import com.thoughtworks.todolist.entity.TodoListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoListRepository extends JpaRepository<TodoListItem, Integer> {
}
