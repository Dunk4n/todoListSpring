package com.example.todoListApi.service;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.example.todoListApi.model.Todo;
import com.example.todoListApi.repository.TodoRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@Service
public class TodoService {

	private TodoRepository todoRepository;
	
	public Todo saveTodo(Todo todo) {
		return todoRepository.save(todo);
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
	
	public Stream<Todo> getTodos() {
		return StreamSupport.stream(todoRepository.findAll().spliterator(), false);
	}

	public void deleteTodo(final Long id) {
		todoRepository.deleteById(id);
	}
}
