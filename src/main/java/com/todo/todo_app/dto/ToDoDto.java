package com.todo.todo_app.dto;

import java.util.Objects;

public class ToDoDto implements Comparable<ToDoDto>{
    private Long id;
    private String name;

    public ToDoDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(ToDoDto o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoDto toDoDto = (ToDoDto) o;
        return Objects.equals(id, toDoDto.id) && Objects.equals(name, toDoDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
