package com.todo.todo_app.service;

import com.todo.todo_app.dto.ToDoDto;

import java.util.Set;

public interface ServiceInterface {

    public Set<ToDoDto> getAllTodo();

    public ToDoDto getTodo(Long id);

    public void createTodo(ToDoDto dto);

    void delete(Long id);
}
