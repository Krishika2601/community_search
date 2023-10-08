package com.products.crud.Product;

public class CustomErrorResponse {

	private String errorMessage;

	public CustomErrorResponse(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}
