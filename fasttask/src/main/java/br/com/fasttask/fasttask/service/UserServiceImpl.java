package br.com.fasttask.fasttask.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fasttask.fasttask.exception.EmailAlreadyExistsException;
import br.com.fasttask.fasttask.exception.InvalidRequestException;
import br.com.fasttask.fasttask.model.User;
import br.com.fasttask.fasttask.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public User createNewUser(User user) throws InvalidRequestException, EmailAlreadyExistsException {	
			
        if (user.getEmail() == null || user.getPassword() == null) {
            throw new InvalidRequestException("Email e senha são obrigatórios!");
        }
        
        if (userRepository.findByEmail(user.getEmail()) != null) {
        	throw new EmailAlreadyExistsException("E-mail já cadastrado!");
        }
        
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
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
	
	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
