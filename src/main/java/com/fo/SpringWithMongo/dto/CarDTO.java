package com.fo.SpringWithMongo.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CarDTO implements Serializable {

	private static final long serialVersionUID = 1989899L;
	
	private String idCar;
	private String licensePlate;
	private String model;
	private String brand;
}
