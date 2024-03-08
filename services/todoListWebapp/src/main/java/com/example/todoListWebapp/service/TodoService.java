package com.example.todoListWebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoListWebapp.model.Todo;
import com.example.todoListWebapp.repository.TodoProxy;

import lombok.Data;

@Data
@Service
public class TodoService {

	@Autowired
	private TodoProxy todoProxy;

	public Todo getTodo(final long id) {
		return todoProxy.getTodo(id);
	}
	
	public Iterable<Todo> getTodos() {
		return todoProxy.getTodos();
	}
	
	public void deleteTodo(final long id) {
		todoProxy.deleteTodo(id);
	}

	public Todo saveTodo(Todo todo) {
		Todo savedTodo;
		
		if(todo.getId() == null) {
			savedTodo = todoProxy.createTodo(todo);
		} else {
			savedTodo = todoProxy.updateTodo(todo);
		}

		return savedTodo;
	}
}
