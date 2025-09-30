package com.amohamed.restapi.todo.controllers;

import org.springframework.web.bind.annotation.*;
import com.amohamed.restapi.todo.models.Todo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private static long idCounter = 0;
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(++idCounter, "amohamed", "Learn Spring Boot", false, "2023-12-31"));
        todos.add(new Todo(++idCounter, "amohamed", "Build REST API", false, "2024-01-15"));
        todos.add(new Todo(++idCounter, "amohamed", "Deploy Application", false, "2024-02-01"));
    }

    // GET /api/todos
    @GetMapping
    public List<Todo> getAllTodos() {
        return todos;
    }

    // GET /api/todos/{id}
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable long id) {
        return todos.stream()
                .filter(todo -> todo.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST /api/todos
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        todo.setId(++idCounter);
        todos.add(todo);
        return todo;
    }

    // PUT /api/todos/{id}
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable long id, @RequestBody Todo updated) {
        Todo todo = todos.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);

        if (todo != null) {
            todo.setUsername(updated.getUsername());
            todo.setDescription(updated.getDescription());
            todo.setDone(updated.isDone());
            todo.setTargetDate(updated.getTargetDate());
        }

        return todo;
    }

    // DELETE /api/todos/{id}
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable long id) {
        todos.removeIf(todo -> todo.getId() == id);
    }
}
