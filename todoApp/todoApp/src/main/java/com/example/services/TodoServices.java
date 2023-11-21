package com.example.services;

import org.springframework.stereotype.Service;

import com.example.repository.TodoRepository;

@Service
public class TodoServices {

	private TodoRepository todoRepository;
	
	public TodoServices (TodoRepository todoRepository){
		this.todoRepository = todoRepository;
	}
}
