package com.products.crud.UserAuth;


import org.springframework.http.HttpStatus;

public class UserException extends Exception {

	private static final long serialVersionUID = 1L;

	private HttpStatus errorStatus;
	private String errorMessage;

	public UserException() {
		super();
	}

	public UserException(String errorMessage, HttpStatus errorStatus) {
		//super(errorMessage);
		this.errorStatus = errorStatus;
		this.errorMessage = errorMessage;
	}

	public HttpStatus getErrorStatus() {
		return errorStatus;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
