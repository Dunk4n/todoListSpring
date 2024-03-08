package com.example.todoListApi.service;

import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoListApi.model.Todo;
import com.example.todoListApi.repository.TodoRepository;

import lombok.Data;

@Data
@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	public Todo saveTodo(Todo todo) {
		Todo savedTodo = todoRepository.save(todo);
		return savedTodo;
	}

	public Optional<Todo> getTodo(final Long id) {
		return todoRepository.findById(id);
	}

	public boolean toggleCompletedTodo(final Long id) {
		Optional<Todo> todo = todoRepository.findById(id);
		
		if (!todo.isPresent())
			return false;
		boolean isCompleted = !todo.get().isCompleted();
		todo.get().setCompleted(isCompleted);
		todo.get().setCompletedOn(new Timestamp(System.currentTimeMillis()));
		todoRepository.save(todo.get());
		return isCompleted;
	}
	
	public Iterable<Todo> getTodos() {
		return todoRepository.findAll();
	}

	public Todo updateTodo(final Long id, Todo todo) {
		try {
			Todo updatedTodo = todoRepository.findById(id).get();
			
			updatedTodo.setTitle(todo.getTitle());
			updatedTodo.setDescription(todo.getDescription());
			updatedTodo.setOnDate(todo.getOnDate());
			updatedTodo.setCardColor(todo.getCardColor());
			updatedTodo.setCompleted(todo.isCompleted());
			updatedTodo.setCompletedOn(todo.getCompletedOn());
			
			return todoRepository.save(updatedTodo);
		} catch (NoSuchElementException e) {
			return todoRepository.save(todo);
		}
	}

	public void deleteTodo(final Long id) {
		todoRepository.deleteById(id);
	}
}
