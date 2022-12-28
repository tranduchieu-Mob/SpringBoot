package com.example.miniproject.service;

import com.example.miniproject.exception.NotFoundException;
import com.example.miniproject.model.Todo;
import com.example.miniproject.repository.TodoRepository;
import com.example.miniproject.request.CreateTodoRequest;
import com.example.miniproject.request.UpdateTodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    public List<Todo> todos;

    public TodoService(){
        todos = new ArrayList<>();
        todos.add(new Todo(1,"Đi chơi", true));
        todos.add(new Todo(2,"Làm bài tập", false));
        todos.add(new Todo(3, "Đá bóng", true));
    }

    public List<Todo> getTodos() {
        return todos;
    }
    public Todo createTodo(CreateTodoRequest request){
        int newId = getTodos().get(getTodos().size() - 1).getId() + 1;
        Todo newTodo = new Todo(
                newId,
                request.getTitle(),
                false
        );
        getTodos().add(newTodo);
        return newTodo;
    }

    public Todo updateTodo(int id, UpdateTodoRequest request){
        for (Todo todo : getTodos()) {
            if (todo.getId() == id) {
                todo.setTitle(request.getTitle());
                todo.setStatus(request.isStatus());
                return todo;
            }
        }
        throw new NotFoundException("ID không tồn tại");
    }
    public void deleteTodo(int id){
        getTodos().removeIf(todo -> todo.getId() == id);
    }

    private Optional<Todo> findById(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst();
    }
}
