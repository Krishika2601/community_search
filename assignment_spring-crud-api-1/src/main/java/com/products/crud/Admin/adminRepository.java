package com.products.crud.Admin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface adminRepository extends JpaRepository<admin, Long> {
	


}