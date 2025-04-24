package br.com.fasttask.fasttask.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fasttask.fasttask.exception.InvalidRequestException;
import br.com.fasttask.fasttask.exception.TaskNotFoundException;
import br.com.fasttask.fasttask.model.Task;
import br.com.fasttask.fasttask.repository.ITaskRepository;

@Service
public class TaskServiceImpl implements ITaskService {

    private final ITaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) throws InvalidRequestException {
    	
        if (task.getName() == null || task.getUser() == null) {
            throw new InvalidRequestException("Nome da tarefa e usuário são obrigatórios!");
        }
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) throws InvalidRequestException, TaskNotFoundException {
        if (task.getId() == null) {
            throw new InvalidRequestException("Id da tarefa é obrigatório para atualização!");
        }
        Task persistedTask = findTaskById(task.getId());
        if (persistedTask == null) {
            throw new TaskNotFoundException("Tarefa não encontrada!");
        }
        return taskRepository.update(task);
    }

    @Override
    public void deleteTask(Task task) throws InvalidRequestException {
        if (task.getId() == null) {
            throw new InvalidRequestException("Id da tarefa é obrigatório para exclusão!");
        }
        taskRepository.delete(task);
    }

    @Override
    public Task findTaskById(Integer taskId) throws TaskNotFoundException {
        Task task = taskRepository.findById(taskId);
        if (task == null) {
            throw new TaskNotFoundException("Tarefa não encontrada!");
        }
        return task;
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findTasksByUserId(Integer userId) {
        return taskRepository.findByUserId(userId);
    }
}
