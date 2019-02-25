package com.fo.SpringWithMongo.model;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Person {

	@Id
	private String idPerson;
	
	private String name;
	private String surname;
	
	private String email;
	
	@Indexed(unique=true)
	private String username;
	
	private String password;
	
	private List<Car> car;
}
