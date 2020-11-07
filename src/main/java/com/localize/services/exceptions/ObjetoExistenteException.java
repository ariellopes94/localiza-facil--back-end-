package com.localize.services.exceptions;

public class ObjetoExistenteException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjetoExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public ObjetoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
