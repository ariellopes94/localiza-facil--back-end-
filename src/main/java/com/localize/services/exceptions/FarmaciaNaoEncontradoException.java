package com.localize.services.exceptions;

public class FarmaciaNaoEncontradoException  extends RuntimeException  {
	private static final long serialVersionUID = 1L;

	public FarmaciaNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public FarmaciaNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
