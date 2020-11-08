package com.localize.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.localize.domain.DetalhesErro;
import com.localize.services.exceptions.ObjectNotFoundException;
import com.localize.services.exceptions.ObjetoExistenteException;

@ControllerAdvice
public class ResourceExceotionHandler {

	@ExceptionHandler(ObjetoExistenteException.class)
	public ResponseEntity<DetalhesErro> handeObjetoExistenteException(ObjetoExistenteException e,
			                                                    HttpServletRequest request ){
		
		DetalhesErro erro = new DetalhesErro();

		erro.setTimestamp(System.currentTimeMillis());
		erro.setStatus(400);
		erro.setError("Já existe no banco de dados");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		erro.setMensagemDesenvolvedor("http://erros.localizafacil.com/400");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<DetalhesErro> handeObjectNotFoundException(ObjectNotFoundException e,
			                                                    HttpServletRequest request ){
		
		DetalhesErro erro = new DetalhesErro();

		erro.setTimestamp(System.currentTimeMillis());
		erro.setStatus(404);
		erro.setError("Não encotrado");
		erro.setMessage(e.getMessage());
		erro.setPath(request.getRequestURI());
		erro.setMensagemDesenvolvedor("http://erros.localizafacil.com/404");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}
