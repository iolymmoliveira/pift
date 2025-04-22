package br.com.fasttask.fasttask.repository;

import br.com.fasttask.fasttask.model.User;

public interface IUserRepository {

	User save(User user);
	User update(User user);
	void delete(User user);
	User findById(Integer id);
	
}
