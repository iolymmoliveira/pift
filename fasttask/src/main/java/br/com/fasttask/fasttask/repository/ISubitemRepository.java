package br.com.fasttask.fasttask.repository;

import java.util.List;

import br.com.fasttask.fasttask.model.Subitem;

public interface ISubitemRepository {

    Subitem save(Subitem subitem);
    Subitem update(Subitem subitem);
    void delete(Subitem subitem);
    Subitem findById(Integer id);
    List<Subitem> findAll();
    List<Subitem> findByTaskId(Integer taskId);
}
