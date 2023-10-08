package com.products.crud.UserAuth;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandlerUser extends ResponseEntityExceptionHandler {

	public static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandlerUser.class);

	@ExceptionHandler(UserException.class)
	public final ResponseEntity<CustomErrorResponseUser> handleUserException(UserException ex, WebRequest request) {
		CustomErrorResponseUser errorDetails = new CustomErrorResponseUser(ex.getMessage());
		return new ResponseEntity<>(errorDetails, ex.getErrorStatus());
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<CustomErrorResponseUser> handleAllExceptions(Exception ex, WebRequest request) {
		logger.error(ex.getMessage());
		CustomErrorResponseUser errorResponse = new CustomErrorResponseUser("Internal error, please contact support.");
		return new ResponseEntity<CustomErrorResponseUser>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

