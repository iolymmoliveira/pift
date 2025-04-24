package br.com.fasttask.fasttask.service;

import java.util.List;

import br.com.fasttask.fasttask.exception.*;
import br.com.fasttask.fasttask.model.Task;

public interface ITaskService {

    public Task createTask(Task task) throws InvalidRequestException;
    public Task updateTask(Task task) throws InvalidRequestException, TaskNotFoundException;
    public void deleteTask(Task task) throws InvalidRequestException;
    public Task findTaskById(Integer taskId) throws TaskNotFoundException;
    public List<Task> findAllTasks();
    public List<Task> findTasksByUserId(Integer userId);
    
}