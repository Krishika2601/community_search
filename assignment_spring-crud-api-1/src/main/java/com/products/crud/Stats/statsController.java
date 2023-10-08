package com.products.crud.Stats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.products.crud.Product.ProductRepository;
import com.products.crud.UserAuth.Status;
import com.products.crud.UserAuth.User;
import com.products.crud.UserAuth.UserRepository;
import com.products.crud.Review.*;
import javax.validation.Valid;
import java.util.List;
@RestController

@CrossOrigin(origins="http://localhost:4200/*")
public class statsController {
	@Autowired
	public ProductRepository productRepository;
	
	
@GetMapping("/stats/product")
@CrossOrigin(origins="http://localhost:4200")
public String stats() {
	long count = productRepository.count();
   return "Products: "+count;
}
@Autowired
public reviewRepository reviewRepository;
@GetMapping("/stats/reviews")
@CrossOrigin(origins="http://localhost:4200")
public String stats2() {
	long count = reviewRepository.count();
   return "Reviews: "+count;
}
@Autowired
public UserRepository userRepository;
@GetMapping("/stats/users")
@CrossOrigin(origins="http://localhost:4200")
public String users() {
	long count = userRepository.count();
   return  "Users: "+ count;
}
	
}


