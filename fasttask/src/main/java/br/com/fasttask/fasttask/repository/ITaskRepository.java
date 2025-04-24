package br.com.fasttask.fasttask.repository;

import java.util.List;

import br.com.fasttask.fasttask.model.Task;

public interface ITaskRepository {

    Task save(Task task);
    Task update(Task task);
    void delete(Task task);
    Task findById(Integer id);
    List<Task> findAll();
    List<Task> findByUserId(Integer userId);
}
