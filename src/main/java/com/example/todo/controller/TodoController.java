package com.example.todo.controller;

import com.example.todo.dto.ResponseDto;
import com.example.todo.dto.TodoDto;
import com.example.todo.dto.TodoResponseDto;
import com.example.todo.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseDto<Void> create(@RequestBody TodoDto todoDto) {
        try {
            todoService.create(todoDto);
            return new ResponseDto<Void>(200, "todo 생성 완료", null);
        } catch (Exception e) {
            return new ResponseDto<Void>(400, e.getMessage(), null);
        }
    }

    @GetMapping("/{id}")
    public ResponseDto<TodoResponseDto> find(@PathVariable UUID id) {
        try {
            TodoResponseDto todo = TodoResponseDto.from(todoService.find(id));
            return new ResponseDto<TodoResponseDto>(200, "todo 조회", List.of(todo));
        } catch (Exception e) {
            return new ResponseDto<TodoResponseDto>(400, e.getMessage(), null);
        }
    }

    @GetMapping
    public ResponseDto<TodoResponseDto> findAll() {
        try {
            List<TodoResponseDto> todoList =  todoService.findAll();
            return new ResponseDto<TodoResponseDto>(200, "todo 전체 조회", todoList);
        } catch (Exception e) {
            return new ResponseDto<TodoResponseDto>(400, e.getMessage(), null);
        }
    }

    @PutMapping("/{id}")
    public ResponseDto<Void> update(@PathVariable UUID id, @RequestBody TodoDto todoDto) {
        try {
            todoService.update(id, todoDto);
            return new ResponseDto<Void>(200, "업데이트에 성공하였습니다.", null);
        } catch (Exception e) {
            return new ResponseDto<Void>(400, e.getMessage(), null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseDto<Void> delete(@PathVariable UUID id) {
        try {
            todoService.delete(id);
            return new ResponseDto<Void>(200, "삭제가 완료되었습니다.", null);
        } catch (Exception e) {
            return new ResponseDto<Void>(400, e.getMessage(), null);
        }
    }
}
