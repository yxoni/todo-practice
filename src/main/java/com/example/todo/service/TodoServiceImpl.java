package com.example.todo.service;

import com.example.todo.domain.Todo;
import com.example.todo.dto.TodoDto;
import com.example.todo.dto.TodoResponseDto;
import com.example.todo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void create(TodoDto todoDto) {
        Todo todo = new Todo(todoDto.title(), todoDto.content());
        todoRepository.save(todo);
    }

    @Override
    public Todo find(UUID id) {
        return Optional.ofNullable(todoRepository.find(id))
                .orElseThrow(() -> new NoSuchElementException("조회에 실패했습니다."));
    }

    @Override
    public List<TodoResponseDto> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public void update(UUID id, TodoDto todoDto) {
        Todo todo = find(id);
        todo.setTitle(todoDto.title());
        todo.setContent(todoDto.content());
        todoRepository.save(todo);
    }

    @Override
    public void delete(UUID id) {
        find(id);
        todoRepository.delete(id);
    }
}
