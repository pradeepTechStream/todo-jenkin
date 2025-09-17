package com.todo.todo_app.controller;

import com.todo.todo_app.dto.ToDoDto;
import com.todo.todo_app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/todo")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public Set<ToDoDto> getAllTodo(){
        return  todoService.getAllTodo();
    }

    @GetMapping("/{id}")
    public ToDoDto getTodo(@PathVariable  Long id){
        return  todoService.getTodo(id);
    }


    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable  Long id){
        todoService.delete(id);
    }

    @PutMapping("/")
    public void todo(@RequestBody ToDoDto dto){
        todoService.createTodo(dto);
    }
}
