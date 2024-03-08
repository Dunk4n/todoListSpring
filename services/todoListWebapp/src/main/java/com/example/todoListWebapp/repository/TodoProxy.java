package com.example.todoListWebapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.todoListWebapp.CustomProperties;
import com.example.todoListWebapp.model.Todo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TodoProxy {

	@Autowired
	private CustomProperties props;
	
	/**
	* Get all todos
	* @return An iterable of all todos
	*/
	public Iterable<Todo> getTodos() {
		String baseApiUrl = props.getApiUrl();
		String getTodosUrl = baseApiUrl + "/todos";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Iterable<Todo>> response = restTemplate.exchange(
				getTodosUrl,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<Iterable<Todo>>() {}
				);
		
		log.debug("Get Todos call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	* Get an todo by the id
	* @param id The id of the todo
	* @return The todo which matches the id
	*/
	public Todo getTodo(long id) {
		String baseApiUrl = props.getApiUrl();
		String getTodoUrl = baseApiUrl + "/todo/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Todo> response = restTemplate.exchange(
				getTodoUrl,
				HttpMethod.GET,
				null,
				Todo.class
				);
		
		log.debug("Get Todo call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	/**
	* Add a new todo 
	* @param e A new todo (without an id)
	* @return The todo full filled (with an id)
	*/
	public Todo createTodo(Todo e) {
		String baseApiUrl = props.getApiUrl();
		String createTodoUrl = baseApiUrl + "/todo";
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Todo> request = new HttpEntity<Todo>(e);
		ResponseEntity<Todo> response = restTemplate.exchange(
				createTodoUrl,
				HttpMethod.POST,
				request,
				Todo.class);
		
		log.debug("Create Todo call " + response.getStatusCode().toString());

		return response.getBody();
	}

	/**
	* Update an todo - using the PUT HTTP Method.
	* @param e Existing todo to update
	*/
	public Todo updateTodo(Todo e) {
		String baseApiUrl = props.getApiUrl();
		String updateTodoUrl = baseApiUrl + "/todo/" + e.getId();
		
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Todo> request = new HttpEntity<Todo>(e);
		ResponseEntity<Todo> response = restTemplate.exchange(
				updateTodoUrl,
				HttpMethod.PUT,
				request,
				Todo.class);
		
		log.debug("Update Todo call " + response.getStatusCode().toString());

		return response.getBody();
	}

	/**
	* Delete an todo using exchange method of RestTemplate
	* instead of delete method in order to log the response status code.
	* @param e The todo to delete
	*/
	public void deleteTodo(long id) {
		String baseApiUrl = props.getApiUrl();
		String deleteTodoUrl = baseApiUrl + "/todo/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteTodoUrl,
				HttpMethod.DELETE,
				null,
				Void.class
				);
		
		log.debug("Delete Todo call " + response.getStatusCode().toString());
	}
}
