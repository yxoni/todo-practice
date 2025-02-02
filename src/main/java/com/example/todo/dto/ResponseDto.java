package com.example.todo.dto;

import java.util.List;

public record ResponseDto<T>(
        int resultCode,
        String message,
        List<T> data
) {
}