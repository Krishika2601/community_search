package com.products.crud.Review;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface reviewRepository extends JpaRepository<review, Long> {
	


}