package br.com.fasttask.fasttask.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fasttask.fasttask.model.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class TaskRepositoryImpl implements ITaskRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Task save(Task task) {
        entityManager.persist(task);
        return task;
    }

    @Transactional
    @Override
    public Task update(Task task) {
        return entityManager.merge(task);
    }

    @Transactional
    @Override
    public void delete(Task task) {
        entityManager.remove(entityManager.contains(task) ? task : entityManager.merge(task));
    }

    @Override
    public Task findById(Integer id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public List<Task> findAll() {
        return entityManager.createQuery("SELECT t FROM Task t", Task.class).getResultList();
    }

    @Override
    public List<Task> findByUserId(Integer userId) {
        return entityManager.createQuery("SELECT t FROM Task t WHERE t.user.id = :userId", Task.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
