package com.products.crud.Review;

public class CustomErrorResponseReview {

	private String errorMessage;

	public CustomErrorResponseReview(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}