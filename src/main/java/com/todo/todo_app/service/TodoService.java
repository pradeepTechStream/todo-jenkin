package com.todo.todo_app.service;

import com.todo.todo_app.dto.ToDoDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TodoService implements ServiceInterface{

    private Set<ToDoDto> commonList=new HashSet<>();

    @Override
    public Set<ToDoDto> getAllTodo() {
        return getAllToDos();
    }

    @Override
    public ToDoDto getTodo(Long id) {
        ToDoDto todo=getAllToDos().stream().filter(e->e.getId()==id).findAny().orElse(null);
        return todo;
    }

    @Override
    public void createTodo(ToDoDto dto) {
        Long id=12L;
        dto.setId(id+commonList.size());
        commonList.add(dto);
    }

    @Override
    public void delete(Long id) {
        commonList.removeIf(e->e.getId()==id);
    }

    private Set<ToDoDto> getAllToDos(){
        ToDoDto dto1=new ToDoDto(10L,"Todo-1");
        ToDoDto dto2=new ToDoDto(11L,"Todo-2");
        commonList.add(dto1);
        commonList.add(dto2);
        return commonList;
    }
}
