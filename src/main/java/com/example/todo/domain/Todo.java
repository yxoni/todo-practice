package com.example.todo.domain;

import java.util.UUID;

public class Todo {
    private final UUID id;
    private String title;
    private String content;

    public Todo(String title, String content) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.content = content;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return title + "| " + content;
    }
}
