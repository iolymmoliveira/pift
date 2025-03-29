package br.com.fasttask.fasttask.service;

import br.com.fasttask.fasttask.model.User;

public interface IUserService {

	public User createNewUser(User user);	
	public User updateUser(User user);	
	public void deleteUser(User user); 
    public User findUserById(Integer userId);

}
