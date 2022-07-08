package com.training.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.postgresql.model.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Integer>{}
