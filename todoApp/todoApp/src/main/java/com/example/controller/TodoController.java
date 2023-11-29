package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.TodoDtoEntity;
import com.example.entity.TodoEntity;
import com.example.services.TodoServices;

@Controller
public class TodoController {

    private TodoServices todoService;

    public TodoController(TodoServices todoService) {
        this.todoService = todoService;
    }

    // Show list of todos and can create todo here
    @GetMapping("/todos")
    public String listClubs(Model model) {
        List<TodoDtoEntity> todos = todoService.findAllClubs();
        model.addAttribute("todos", todos);
        return "todos-list";
    }

    @GetMapping("/todos/new")
    public String createTodoForm(Model model) {
        TodoEntity todo = new TodoEntity();
        model.addAttribute("todo", todo);
        return "todo-create";

    }

    @PostMapping("/todos/new")
    public String saveClub(@ModelAttribute("todo") TodoEntity todoEntity) {
        todoService.saveTodo(todoEntity);
        return "redirect:/todos";
    }

    @GetMapping("/todos/delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodos(id);
        return "redirect:/todos";
    }

}
