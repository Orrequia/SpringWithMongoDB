package com.fo.SpringWithMongo.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Car {

	@Id
	private String  idCar;  
	
	@Indexed(unique=true)
	private String licensePlate;
	
	private String model;
	private String brand;
}
