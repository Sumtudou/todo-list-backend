package com.thoughtworks.todolist.repository;

import com.thoughtworks.todolist.entity.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodolistRepository extends JpaRepository<Todolist, Integer> {
}