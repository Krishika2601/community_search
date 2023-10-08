package com.products.crud.UserAuth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.products.crud.Product.IProductService;
import com.products.crud.Product.Product;
import com.products.crud.Product.ProductController;
import com.products.crud.Product.ProductException;
import com.products.crud.Review.ReviewException;

import javax.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
	private UserService UserService;
	@GetMapping("/users")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> list = UserService.getAllUsers();
		return ResponseEntity.ok(list);
		// return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
   

    @PostMapping("/users/register")
    @CrossOrigin(origins="http://localhost:4200")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user, Errors errors) throws UserException {

		if (errors.hasErrors()) {
			throw new UserException(errors.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
if(user.getemail()==""||user.getFirstname()==""||user.getLastname()==""||user.getPassword()=="") {
	logger.error("not allowed");
	throw new UserException("NOT Allowed",HttpStatus.FORBIDDEN);
}
		boolean userExists = UserService.findUserByFirstname(user.getFirstname()) != null;
		if (userExists) {
			logger.error("Unable to create. A user with name {} already exist", user.getFirstname());
			throw new UserException("Unable to create. A user with name " + user.getFirstname() + " already exist.",
					HttpStatus.CONFLICT);

		}

		UserService.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
    
    @PostMapping("/users/login")
    @CrossOrigin(origins="http://localhost:4200/login")
    public Status loginUser(@Valid @RequestBody User user  ,Errors errors) throws UserException {
        List<User> users = userRepository.findAll();
      
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(true);
                if (errors.hasErrors()) {
        			throw new UserException(errors.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        		}
                return Status.SUCCESS;
            }
          
        }
        throw new UserException("Unable to login. A user with name " + user.getFirstname() + " Kindly chcek.",
				HttpStatus.FORBIDDEN);
    }
   
    @PostMapping("/users/logout")
    @CrossOrigin(origins="http://localhost:4200")
    public Status logUserOut(@Valid @RequestBody User user) {
        List<User> users = userRepository.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                user.setLoggedIn(false);
               
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }
    @CrossOrigin(origins="http://localhost:4200")
    @DeleteMapping("/users/all")
    public Status deleteUsers() {
        userRepository.deleteAll();
        return Status.SUCCESS;
    }
}
