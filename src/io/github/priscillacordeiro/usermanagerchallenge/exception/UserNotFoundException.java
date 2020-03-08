package io.github.priscillacordeiro.usermanagerchallenge.exception;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -2848338738886942215L;

	public UserNotFoundException(String message) {
		super(message);
	}

}