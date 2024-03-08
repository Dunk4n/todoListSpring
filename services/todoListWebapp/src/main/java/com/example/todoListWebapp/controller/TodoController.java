package com.example.todoListWebapp.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.todoListWebapp.model.Todo;
import com.example.todoListWebapp.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	private TodoService service;
	
	@GetMapping("/")
	public String home(Model model) {
		Iterable<Todo> listTodo = service.getTodos();
		model.addAttribute("todos", listTodo);

		return "home";
	}
	
	@GetMapping("/createTodo")
	public String createTodo(Model model) {
		Todo e = new Todo();
		e.setOnDate(new Date(System.currentTimeMillis()));
		model.addAttribute("todo", e);
		return "formNewTodo";
	}
	
	@GetMapping("/updateTodo/{id}")
	public String updateTodo(@PathVariable("id") final int id, Model model) {
		Todo e = service.getTodo(id);
		model.addAttribute("todo", e);
		return "formUpdateTodo";		
	}

	@GetMapping("/deleteTodo/{id}")
	public ModelAndView deleteTodo(@PathVariable("id") final int id) {
		service.deleteTodo(id);
		return new ModelAndView("redirect:/");		
	}
	
	@PostMapping("/saveTodo")
	public ModelAndView saveTodo(@ModelAttribute Todo todo) {
		service.saveTodo(todo);
		return new ModelAndView("redirect:/");
	}
}
