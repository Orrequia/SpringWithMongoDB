package com.fo.SpringWithMongo.dto;

import java.io.Serializable;
import java.util.List;

import com.fo.SpringWithMongo.model.Car;

import lombok.Data;

@Data
public class PersonDTO implements Serializable {

	private static final long serialVersionUID = 109878979L;
	
	private String idPerson;
	private String name;
	private String surname;
	private String email;
	private String username;
	private List<Car> car;
}
