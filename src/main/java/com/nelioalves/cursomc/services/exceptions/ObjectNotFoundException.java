package com.nelioalves.cursomc.services.exceptions;

/*
 * Implementação padrão de tratamento de excessões utilizando a RuntimeExceptio.
 */
public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
