package br.com.bemlonge.exception;

public class ClienteException extends Exception{
	private static final long serialVersionUID = 6206041088631560061L;

	public ClienteException(String message){
		super(message);
	}
}
