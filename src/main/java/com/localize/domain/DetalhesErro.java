package com.localize.domain;

import java.io.Serializable;

public class DetalhesErro implements Serializable {
private static final long serialVersionUID = 1L;
	
	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	private String mensagemDesenvolvedor;
	
	public DetalhesErro() {
	}

	public DetalhesErro(Integer status, String error, String message, String path, String mensagemDesenvolvedor) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMensagemDesenvolvedor() {
		return mensagemDesenvolvedor;
	}

	public void setMensagemDesenvolvedor(String mensagemDesenvolvedor) {
		this.mensagemDesenvolvedor = mensagemDesenvolvedor;
	}
}