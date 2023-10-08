package com.products.crud.UserAuth;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.crud.Product.Product;
import com.products.crud.Product.ProductRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public List<User> getAllUsers() {
		List<User> User = new ArrayList<>();
		UserRepository.findAll().forEach(User::add);
		
		return User;
	}
	@Override
	public User findUserByFirstname(String firstname) {
		return UserRepository.findByFirstname(firstname);
	}
	@Override
	public void addUser(User User) {
		UserRepository.save(User);
	}


}