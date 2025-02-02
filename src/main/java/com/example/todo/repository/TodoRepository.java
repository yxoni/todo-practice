package com.example.todo.repository;

import com.example.todo.domain.Todo;
import com.example.todo.dto.TodoResponseDto;

import java.util.List;
import java.util.UUID;

public interface TodoRepository {
    void save(Todo todo);
    Todo find(UUID id);
    List<TodoResponseDto> findAll();
    void delete(UUID id);
}
