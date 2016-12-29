package br.com.titans.tryout.exception;

import org.springframework.http.HttpStatus;

public class EmailDuplicadoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6817210147138240527L;

	@Override
	public String getMessage() {
		return "Email já cadastrado!";
	}
	
	public HttpStatus getHttpStatus(){
		return HttpStatus.UNPROCESSABLE_ENTITY;
	}

}
