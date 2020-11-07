package com.localize.services.exceptions;

public class BairroExistenteException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BairroExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public BairroExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
