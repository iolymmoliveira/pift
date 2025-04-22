package br.com.fasttask.fasttask.exceptions;

public class EmailAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public EmailAlreadyExistsException(String message) {
		super(message);
	}
}
