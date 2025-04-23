package br.com.fasttask.fasttask.service;

import br.com.fasttask.fasttask.exception.EmailAlreadyExistsException;
import br.com.fasttask.fasttask.exception.InvalidRequestException;
import br.com.fasttask.fasttask.model.User;

public interface IUserService {

	public User createNewUser(User user) throws InvalidRequestException, EmailAlreadyExistsException;	
	public User updateUser(User user);	
	public void deleteUser(User user); 
    public User findUserById(Integer userId);
    public User findUserByEmail(String email);
}
