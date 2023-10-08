package com.products.crud.UserAuth;
public class CustomErrorResponseUser {

	private String errorMessage;

	public CustomErrorResponseUser(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
}