package io.github.priscillacordeiro.usermanagerchallenge.service;

import java.util.List;

import io.github.priscillacordeiro.usermanagerchallenge.model.User;
import io.github.priscillacordeiro.usermanagerchallenge.repository.UserRepository;

public class UserService {
	
	private UserRepository userRepository = new UserRepository();
	
	public User create(User user) {
		return userRepository.create(user);
	}
	
	public List<User> getAll() {
		return userRepository.getAll();
	}
	
	public User getById(Long id) {
		return userRepository.getById(id);
	}
	
	public User getByEmail(String email) {
		return userRepository.getByEmail(email);
	}
	
	public User update(User user) {
		return userRepository.update(user);
	}
	
	public void delete(Long id) {
		userRepository.delete(id);
	}
	
}
