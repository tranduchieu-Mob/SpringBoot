package com.example.miniproject.controller;
import com.example.miniproject.model.Todo;
import com.example.miniproject.request.CreateTodoRequest;
import com.example.miniproject.request.UpdateTodoRequest;
import com.example.miniproject.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class ToDoController {
    @Autowired
    private TodoService todoService;
    //1.lấy danh sách todos
    @GetMapping("todos")
    public List<Todo> getTodos(){
        return todoService.getTodos();
    }

    //2. Tạo todo
    @PostMapping("todos")
    public Todo createTodo(@RequestBody CreateTodoRequest request){
        return todoService.createTodo(request);
    }

    //3. Cập nhật todo
    @PutMapping("todos/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody UpdateTodoRequest request){
        return todoService.updateTodo(id,request);
    }

    //4. xóa todo
    @DeleteMapping("todos/{id}")
    public void deleteTodo(@PathVariable int id){
        todoService.deleteTodo(id);
    }
}
