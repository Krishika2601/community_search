package com.products.crud.Stats;
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

public class stats {
@Id
@GeneratedValue
private Integer id;
private String url;
private Integer counter;
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public Integer getCounter() {
	return counter;
}
public void setCounter(Integer counter) {
	this.counter = counter;
}
public stats() {};
public stats(String url, Integer counter) {
	super();
	this.url = url;
	this.counter = counter;
}


}
