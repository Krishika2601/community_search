package com.products.crud.Admin;


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
@Table(name = "admin")
public class admin {
	
	private @Id @GeneratedValue long id;
private String email;
private  boolean loggedIn;

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
private String password;

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean isLoggedIn() {
    return loggedIn;
}
public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
}

 public admin() {
	 
 
 }
public admin( String email, String password) {
	super();
	this.email = email;
	this.password = password;
	 this.loggedIn = false;
}
@Override
public String toString() {
    return "Admin{" +
            "id=" + id +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", loggedIn=" + loggedIn +
            '}';
}
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof admin)) return false;
    admin admin = (admin) o;
    return Objects.equals(email, admin.email) &&
            Objects.equals(password, admin.password);
}


}
