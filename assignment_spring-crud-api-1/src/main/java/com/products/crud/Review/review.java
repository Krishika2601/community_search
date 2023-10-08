package com.products.crud.Review;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Objects;
@Entity
@Table(name = "reviews")
public class review {
	
	private @Id @GeneratedValue long id;
private int rating;
public int getRating() {
	return rating;
}
public void setRating(int rating) {
	this.rating = rating;
}
private String brand;

public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
private String review;
private String product;

public String getReview() {
	return review;
}
public void setReview(String review) {
	this.review = review;
}
public String getProduct() {
	return product;
}
public void setProduct(String product) {
	this.product = product;
}
 public review() {
	 
 
 }
public review(int rating, String review, String product) {
	super();
	this.rating = rating;
	this.review = review;
	this.product = product;
}
public long getId() {
	return id;
}
@Override
public String toString() {
    return "review{" +
            "id=" + id +
            ", rating='" + rating + '\'' +
            ", review='" + review + '\'' +
            ", product=" + product +
            '}';
}
 

}
