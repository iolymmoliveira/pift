package br.com.fasttask.fasttask.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fasttask.fasttask.model.Subitem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class SubitemRepositoryImpl implements ISubitemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Subitem save(Subitem subitem) {
        entityManager.persist(subitem);
        return subitem;
    }

    @Transactional
    @Override
    public Subitem update(Subitem subitem) {
        return entityManager.merge(subitem);
    }

    @Transactional
    @Override
    public void delete(Subitem subitem) {
        entityManager.remove(entityManager.contains(subitem) ? subitem : entityManager.merge(subitem));
    }

    @Override
    public Subitem findById(Integer id) {
        return entityManager.find(Subitem.class, id);
    }

    @Override
    public List<Subitem> findAll() {
        return entityManager.createQuery("SELECT s FROM Subitem s", Subitem.class).getResultList();
    }

    @Override
    public List<Subitem> findByTaskId(Integer taskId) {
        return entityManager.createQuery("SELECT s FROM Subitem s WHERE s.task.id = :taskId", Subitem.class)
                .setParameter("taskId", taskId)
                .getResultList();
    }
}