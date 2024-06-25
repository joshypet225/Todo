package com.springproject.todo;

import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/")

public class TodoController {
 private final TodoRepository todorepository;
 public TodoController(TodoRepository todoRepository){
    this.todorepository=todoRepository;
 }
 @PostMapping("/")
 public Todo createTodo (@RequestBody Todo todo) { 
     return todorepository.save(todo);
 }
 @GetMapping("/")
 public Iterable<Todo> getAllTodo() {
     return todorepository.findAll();
 }
 
 @GetMapping("/{id}")
 public Todo getTodo(@RequestParam Long id) {
     return todorepository.findById(id)
                                       .orElseThrow(()-> new EntityNotFoundException("Task not found"+id));
 }
 
 @PutMapping("/{id}")
 public Todo updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
     Todo todo = todorepository.findById(id) 
                                          .orElseThrow(()-> new EntityNotFoundException("Task not found"+id));
    todo.setTitle(updatedTodo.getTitle());
    todo.setDescription(updatedTodo.getDescription());
    todo.setDuedate(updatedTodo.getDuedate());
    todo.setstatus(updatedTodo.getstatus());
     return todorepository.save(todo);
 }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        try {
            todorepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

 }
 




