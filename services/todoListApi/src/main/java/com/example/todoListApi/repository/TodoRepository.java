package com.example.todoListApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.todoListApi.model.Todo;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

}
