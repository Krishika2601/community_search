package com.products.crud.Admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.crud.Admin.admin;
import com.products.crud.Admin.adminRepository;
import com.products.crud.Admin.adminService;

@Service
public class adminServiceImp implements adminService {

	@Autowired
	private adminRepository adminRepository;
	
	@Override
	public List<admin> getAllAdmins() {
		List<admin> Admin = new ArrayList<>();
		adminRepository.findAll().forEach(Admin::add);
		
		return Admin;
	}




}