package com.github.dustyD3V.model;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    boolean existsById(int id);
    List<Task> findAll();
    Optional<Task> findById(int id);
    Task save(Task entity);
}
