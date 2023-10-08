package com.products.crud.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.products.crud.UserAuth.Status;
import com.products.crud.UserAuth.User;

import javax.validation.Valid;
import java.util.List;
@RestController

@CrossOrigin(origins="http://localhost:4200/*")
public class adminController {
@Autowired
adminRepository adminRepo;
@PostMapping("/admin/login")
@CrossOrigin(origins="http://localhost:4200/login")
public Status loginAdmin(@Valid @RequestBody admin admin) {
    List<admin> admins = adminRepo.findAll();
    for (admin other : admins) {
        if (other.equals(admin)) {
            admin.setLoggedIn(true);
           
            return Status.SUCCESS;
        }
    }
    return Status.FAILURE;
}


}

