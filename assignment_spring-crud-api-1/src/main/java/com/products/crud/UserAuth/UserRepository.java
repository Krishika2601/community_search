package com.products.crud.UserAuth;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.products.crud.Product.Product;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByFirstname(String firstname);



}
