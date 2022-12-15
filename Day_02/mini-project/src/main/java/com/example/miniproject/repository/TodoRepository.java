package com.example.miniproject.repository;

import com.example.miniproject.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TodoRepository {
    private List<Todo> todoList;

    private void initTodos() {
        todoList = new ArrayList<>();
        todoList.add(new Todo(1, "Đi chơi", true));
        todoList.add(new Todo(2, "Làm bài tập", false));
        todoList.add(new Todo(3, "Đá bóng", true));
    }

    private TodoRepository() {
        initTodos();
    }

    public List<Todo> findAll() {
        return todoList;
    }

    public Optional<Todo> findById(int id) {
        return todoList.stream().filter(todo -> todo.getId() == id).findFirst();
    }
}