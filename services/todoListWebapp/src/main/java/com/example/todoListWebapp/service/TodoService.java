package com.example.todoListWebapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todoListWebapp.model.Todo;
import com.example.todoListWebapp.repository.TodoProxy;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Service
public class TodoService {

	private TodoProxy todoProxy;

	public Todo getTodo(final long id) {
		return todoProxy.getTodo(id);
	}
	
	public List<Todo> getTodos() {
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
