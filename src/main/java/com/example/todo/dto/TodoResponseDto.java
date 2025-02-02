package com.example.todo.dto;

import com.example.todo.domain.Todo;

import java.util.UUID;

public record TodoResponseDto (
        UUID id,
        String title,
        String content

) {
    public static TodoResponseDto from(Todo todo) {
        return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.getContent());
    }
}
