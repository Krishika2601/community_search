package com.products.crud.Review;




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
public class CustomExceptionHandlerReview extends ResponseEntityExceptionHandler {

	public static final Logger logger = LoggerFactory.getLogger(CustomExceptionHandlerReview.class);

	@ExceptionHandler(ReviewException.class)
	public final ResponseEntity<CustomErrorResponseReview> handleReviewException(ReviewException ex, WebRequest request) {
		CustomErrorResponseReview errorDetails = new CustomErrorResponseReview(ex.getMessage());
		return new ResponseEntity<>(errorDetails, ex.getErrorStatus());
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<CustomErrorResponseReview> handleAllExceptions(Exception ex, WebRequest request) {
		logger.error(ex.getMessage());
		CustomErrorResponseReview errorResponse = new CustomErrorResponseReview("Internal error, please contact support.");
		return new ResponseEntity<CustomErrorResponseReview>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

