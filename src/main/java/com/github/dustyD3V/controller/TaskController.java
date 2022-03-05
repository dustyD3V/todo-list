package com.github.dustyD3V.controller;

import com.github.dustyD3V.model.Task;
import com.github.dustyD3V.model.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
class TaskController {
    private static final Logger     logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository    repository;

    TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/tasks")
    ResponseEntity<?> createTask(@RequestBody @Valid Task toSave) {
        //TODO Add an error message to response body when toSave is not @valid
        logger.info("Preparation to save new task.");
        Task task = toSave;
        repository.save(task);
        logger.info("A new task has been saved.");
        return ResponseEntity.created(URI.create("tasks/" + task.getId())).build();
        //TODO Add smarter way for URI implementation
    }

    @GetMapping("/tasks")
    ResponseEntity<List<Task>> readAllTasks() {
        logger.info("Listing all tasks.");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/tasks/{id}")
    ResponseEntity<Optional<Task>> readTask(@PathVariable int id) {
        if (!repository.existsById(id)) {
            logger.info("Task not found.");
            return ResponseEntity.notFound().build();
        }
        logger.info("Listing the found task.");
        return ResponseEntity.ok(repository.findById(id));
    }

    @PutMapping("/tasks/{id}")
    ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody @Valid Task toUpdate) {
        if (!repository.existsById(id)) {
            logger.info("Task not found.");
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        repository.save(toUpdate);
        logger.info("Selected task has been updated.");
        return ResponseEntity.noContent().build();
    }
}
