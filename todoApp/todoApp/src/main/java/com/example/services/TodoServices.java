package com.example.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.dto.TodoDtoEntity;
import com.example.repository.TodoRepository;
import com.example.entity.TodoEntity;

@Service
public class TodoServices {

    private TodoRepository todoRepository;

    public TodoServices(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // shows list of todos
    public List<TodoDtoEntity> findAllClubs() {
        List<TodoEntity> todos = todoRepository.findAll();
        return todos.stream().map((todo) -> mapToTodoDto(todo)).collect(Collectors.toList());

    }

    // save a todo
    public TodoEntity saveTodo(TodoEntity Todo) {
        return todoRepository.save(Todo);
    }

    private TodoDtoEntity mapToTodoDto(TodoEntity todo) {
        TodoDtoEntity todoDto = TodoDtoEntity.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .content(todo.getContent())
                .build();

        return todoDto;
    }

    public void deleteTodos(Long id) {
        todoRepository.deleteById(id);
    }
}
