package com.api.catalog.service.exceptions;

public class CodAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CodAlreadyExistsException(String msg){
		super(msg);
	}
	
}
