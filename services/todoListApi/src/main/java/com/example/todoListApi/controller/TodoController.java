package com.example.todoListApi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoListApi.model.Todo;
import com.example.todoListApi.service.TodoService;

@RestController
public class TodoController {

	@Autowired
	private TodoService todoService;

	/**
	* Create - Add a new todo
	* @param todo An object todo
	* @return The todo object saved
	*/
	@PostMapping("/todo")
	public Todo createTodo(@RequestBody Todo todo) {
		if (todo.getTitle() == null)
			todo.setTitle("");
		if (todo.getDescription() == null)
			todo.setDescription("");
		return todoService.saveTodo(todo);
	}
	
	/**
	* Read - Get one todo 
	* @param id The id of the todo
	* @return An Todo object full filled
	*/
	@GetMapping("/todo/{id}")
	public Todo getTodo(@PathVariable("id") final Long id) {
		Optional<Todo> todo = todoService.getTodo(id);
		if(todo.isPresent()) {
			return todo.get();
		} else {
			return null;
		}
	}
	
	/**
	* Read - toggle Completed Todo
	* @param id The id of the todo
	* @return A boolean representing the isCompleted field
	*/
	@CrossOrigin(origins = "http://localhost:9000")
	@GetMapping("/todo/{id}/toggleCompleted")
	public boolean toggleCompletedTodo(@PathVariable("id") final Long id) {
		return todoService.toggleCompletedTodo(id);
	}

	/**
	* Read - Get all todos
	* @return - An Iterable object of Todo full filled
	*/
	@GetMapping("/todos")
	public Iterable<Todo> getTodos() {
		return todoService.getTodos();
	}

	/**
	 * Update - Update an existing todo
	 * @param id - The id of the todo to update
	 * @param todo - The todo object updated
	 * @return
	 */
	@PutMapping("/todo/{id}")
	public Todo updateTodo(@PathVariable("id") final Long id, @RequestBody Todo todo) {
		return todoService.updateTodo(id, todo);
	}

	/**
	* Delete - Delete an todo
	* @param id - The id of the todo to delete
	*/
	@DeleteMapping("/todo/{id}")
	public void deleteTodo(@PathVariable("id") final Long id) {
		todoService.deleteTodo(id);
	}
}
