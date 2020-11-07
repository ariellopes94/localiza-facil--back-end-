package com.localize.services.exceptions;

public class FarmaciaNaoEncontradoException  extends RuntimeException  {
	
	public FarmaciaNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public FarmaciaNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
