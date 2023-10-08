package com.products.crud.UserAuth;



import java.util.List;
import java.util.Optional;

import com.products.crud.Product.Product;

public interface UserService {

	List<User> getAllUsers();

	User findUserByFirstname(String firstname);

	void addUser(User user);

	
	


    
}