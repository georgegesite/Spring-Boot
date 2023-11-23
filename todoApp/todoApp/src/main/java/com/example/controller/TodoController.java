package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dto.TodoDtoEntity;
import com.example.services.TodoServices;

@Controller
public class TodoController {

    private TodoServices todoService;

    public TodoController(TodoServices todoService) {
        this.todoService = todoService;
    }

    // comment
    @GetMapping("/todos")
    public String listClubs(Model model) {
        List<TodoDtoEntity> todos = todoService.findAllClubs();
        model.addAttribute("todos", todos);
        return "todos-list";
    }

}
