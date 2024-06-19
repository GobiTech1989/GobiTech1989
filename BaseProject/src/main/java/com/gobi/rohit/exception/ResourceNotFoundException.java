package com.gobi.rohit.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 841571052204377436L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
