package io.github.priscillacordeiro.usermanagerchallenge.exception;

public class UserNotFound extends RuntimeException {
	
	private static final long serialVersionUID = -2848338738886942215L;

	public UserNotFound(String message) {
		super(message);
	}

}
