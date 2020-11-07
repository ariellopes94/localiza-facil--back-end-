package com.localize.services.exceptions;

public class FarmaciaNaoPodeSerExcluidaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public FarmaciaNaoPodeSerExcluidaException(String mensagem) {
		super(mensagem);
	}
	
	public FarmaciaNaoPodeSerExcluidaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
