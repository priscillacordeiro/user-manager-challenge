package io.github.priscillacordeiro.usermanagerchallenge.service;

import java.util.List;

import io.github.priscillacordeiro.usermanagerchallenge.exception.EmailAlreadyExistsException;
import io.github.priscillacordeiro.usermanagerchallenge.exception.InvalidLoginException;
import io.github.priscillacordeiro.usermanagerchallenge.exception.UserNotFound;
import io.github.priscillacordeiro.usermanagerchallenge.model.User;
import io.github.priscillacordeiro.usermanagerchallenge.repository.UserRepository;

public class UserService {
	
	private UserRepository userRepository = new UserRepository();
	
	public User create(User user) {
		User savedUser = userRepository.getByEmail(user.getEmail());
		if(savedUser != null) {
			throw new EmailAlreadyExistsException("E-mail already exists!");
		}
		return userRepository.create(user);
	}
	
	public List<User> getAll() {
		return userRepository.getAll();
	}
	
	public User getById(Long id) throws UserNotFound {
		User user = userRepository.getById(id);
		if(user == null) {
			throw new UserNotFound("User not found!");
		}
		return user;
	}
	
	public User getByEmail(String email) {
		return userRepository.getByEmail(email);
	}
	
	public User update(User user) {
		User emailUser = userRepository.getByEmail(user.getEmail());
		User originalUser = userRepository.getById(user.getId());
		
		if(originalUser.getEmail().equals(user.getEmail()) || emailUser == null) {
			return userRepository.update(user);
		} else {
			throw new EmailAlreadyExistsException("E-mail already exists!");
		}
	}
	
	public void delete(Long id) {
		userRepository.delete(id);
	}
	
	public User login(String email, String password) {
		User user = userRepository.getByEmail(email);
		
		if(user != null && password.equals(user.getPassword())) {
			return user;
		} else {
			throw new InvalidLoginException("E-mail or password invalid!");
		}
	}
	
}