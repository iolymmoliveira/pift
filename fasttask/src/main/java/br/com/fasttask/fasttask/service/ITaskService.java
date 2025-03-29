package br.com.fasttask.fasttask.service;

import java.util.List;

import br.com.fasttask.fasttask.model.Task;

public interface ITaskService {

    public Task createTask(Task task);
    public Task updateTask(Task task);
    public void deleteTask(Task task);
    public Task findTaskById(Integer taskId);
    public List<Task> findAllTasks();
    public List<Task> findTasksByUserId(Integer userId);
    
}
