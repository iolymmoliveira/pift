package br.com.fasttask.fasttask.service;

import br.com.fasttask.fasttask.exception.*;
import br.com.fasttask.fasttask.model.User;

public interface IUserService {

	public User createNewUser(User user) throws InvalidRequestException, EmailAlreadyExistsException;	
	public User updateUser(User user) throws InvalidRequestException, UserNotFoundException, EmailAlreadyExistsException;	
	public void deleteUser(User user) throws InvalidRequestException, UserNotFoundException; 
    public User findUserById(Integer userId) throws UserNotFoundException;
    public User findUserByEmail(String email) throws UserNotFoundException;
}
