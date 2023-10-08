package com.products.crud.Review;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.crud.Admin.admin;
import com.products.crud.Admin.adminRepository;
import com.products.crud.Admin.adminService;

@Service
public class reviewServiceImp implements reviewService {

	@Autowired
	private reviewRepository reviewRepository;
	
	@Override
	public List<review> getAllreviews() {
		List<review> review = new ArrayList<>();
		reviewRepository.findAll().forEach(review::add);
		
		return review;
	}
}
