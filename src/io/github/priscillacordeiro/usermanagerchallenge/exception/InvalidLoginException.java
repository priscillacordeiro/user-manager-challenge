package io.github.priscillacordeiro.usermanagerchallenge.exception;

public class InvalidLoginException extends RuntimeException {
	private static final long serialVersionUID = 4640251333217904315L;
	
	public InvalidLoginException(String message) {
		super(message);
	}

}
