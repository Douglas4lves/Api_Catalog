package com.api.catalog.service.exceptions;

public class CategoryNameAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CategoryNameAlreadyExistsException(String msg) {
		super(msg);
	}
}
