package com.example.todo.repository;

import com.example.todo.domain.Todo;
import com.example.todo.dto.TodoResponseDto;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class TodoRepositoryImpl implements TodoRepository {

    private final Map<UUID, Todo> todoList;

    public TodoRepositoryImpl() {
        this.todoList = new HashMap<>();
    }

    @Override
    public void save(Todo todo) {
        todoList.put(todo.getId(), todo);
    }

    @Override
    public Todo find(UUID id) {
        return todoList.get(id);
    }

    @Override
    public List<TodoResponseDto> findAll() {
        return todoList.values().stream()
                .map(TodoResponseDto::from)
                .toList();
    }

    @Override
    public void delete(UUID id) {
        todoList.remove(id);
    }
}
