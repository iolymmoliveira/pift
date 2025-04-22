package br.com.fasttask.fasttask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fasttask.fasttask.model.User;
import br.com.fasttask.fasttask.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public User createNewUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(User user) {
		return userRepository.update(user);
	}
	
	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	@Override
    public User findUserById(Integer userId) {
		return userRepository.findById(userId);
	}
}
