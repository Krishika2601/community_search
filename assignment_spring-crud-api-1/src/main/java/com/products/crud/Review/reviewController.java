package com.products.crud.Review;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.products.crud.Product.ProductException;
import com.products.crud.UserAuth.User;
import com.products.crud.UserAuth.UserController;
import com.products.crud.UserAuth.UserService;

import javax.validation.Valid;

import java.net.URI;
import java.util.List;
@RestController

@CrossOrigin(origins="http://localhost:4200/*")
public class reviewController {
	public static final Logger logger = LoggerFactory.getLogger(reviewController.class);
@Autowired
reviewRepository reviewRepo;
@PostMapping("/review/product")
@CrossOrigin(origins="http://localhost:4200")
public @Valid review addReview(@Valid @RequestBody review review, Errors errors)throws ReviewException {
	logger.error("not allowed");
	if (errors.hasErrors()) {
		logger.error("not allowed");
		throw new ReviewException(errors.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
	}
	if(review.getProduct()==null||review.getReview()==null||review.getBrand()==null) {
		logger.error("not allowed");
		throw new ReviewException("NOT Allowed",HttpStatus.FORBIDDEN);
	}
	if(review.getProduct()==""||review.getReview()==""||review.getBrand()=="") {
		logger.error("not allowed");
		throw new ReviewException("NOT Allowed",HttpStatus.FORBIDDEN);
	}
	
	else {
	
	

		return  reviewRepo.save(review);
	}}

@Autowired
	private reviewService reviewService;
@GetMapping("/reviews")
@CrossOrigin(origins="http://localhost:4200")
public ResponseEntity<List<review>> getAllreviews() {
	List<review> list = reviewService.getAllreviews();
	return ResponseEntity.ok(list);
	// return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
}


}
