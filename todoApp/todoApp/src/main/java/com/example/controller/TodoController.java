package com.example.controller;

import org.springframework.stereotype.Controller;

import com.example.services.TodoServices;

@Controller
public class TodoController {

	private TodoServices todoService;
	
	public TodoController(TodoServices todoService) {
		this.todoService = todoService;
	}
}
