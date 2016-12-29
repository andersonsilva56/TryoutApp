package br.com.titans.tryout.exception;

import java.lang.reflect.Field;

import org.springframework.http.HttpStatus;

public class CampoObrigatorioException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8081930325671146452L;

	private Field campo;
	private final String VALOR_PADRAO = "Campo Obrigatório!: "; 
	
	public CampoObrigatorioException(Field campo) {
		this.campo = campo;
	}
	
	@Override
	public String getMessage() {
		return criarMensagem();
	}
	
	public HttpStatus getHttpStatus(){
		return HttpStatus.UNPROCESSABLE_ENTITY;
	}
	
	private String criarMensagem(){
		StringBuffer buffer =  new StringBuffer(VALOR_PADRAO);
		buffer.append(Character.toUpperCase(campo.getName().charAt(0)) + campo.getName().substring(1));
		return buffer.toString();
	}
}
