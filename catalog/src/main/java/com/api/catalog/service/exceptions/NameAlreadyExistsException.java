package com.api.catalog.service.exceptions;

public class NameAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NameAlreadyExistsException(String msg) {
		super(msg);
	}
}
