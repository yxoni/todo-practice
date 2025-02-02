package com.example.todo.service;

import com.example.todo.domain.Todo;
import com.example.todo.dto.TodoDto;
import com.example.todo.dto.TodoResponseDto;

import java.util.List;
import java.util.UUID;

public interface TodoService {
    void create(TodoDto todoDto);
    Todo find(UUID id);
    List<TodoResponseDto> findAll();
    void update(UUID id, TodoDto todoDto);
    void delete(UUID id);
}
