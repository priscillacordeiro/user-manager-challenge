package io.github.priscillacordeiro.usermanagerchallenge.exception;

public class EmailAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1314585623534886537L;

	public EmailAlreadyExistsException(String message) {
		super(message);
	}

}
