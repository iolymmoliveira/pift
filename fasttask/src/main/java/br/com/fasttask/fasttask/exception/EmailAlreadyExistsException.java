package br.com.fasttask.fasttask.exception;

public class EmailAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public EmailAlreadyExistsException(String message) {
		super(message);
	}
}
