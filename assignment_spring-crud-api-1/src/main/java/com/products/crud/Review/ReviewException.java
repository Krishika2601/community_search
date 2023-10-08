package com.products.crud.Review;


import org.springframework.http.HttpStatus;

public class ReviewException extends Exception {

	private static final long serialVersionUID = 1L;

	private HttpStatus errorStatus;
	private String errorMessage;

	public ReviewException() {
		super();
	}

	public ReviewException(String errorMessage, HttpStatus errorStatus) {
		super(errorMessage);
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
