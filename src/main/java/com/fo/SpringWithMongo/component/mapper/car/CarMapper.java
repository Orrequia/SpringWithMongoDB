package com.fo.SpringWithMongo.component.mapper.car;

import java.util.List;

import com.fo.SpringWithMongo.dto.CarDTO;
import com.fo.SpringWithMongo.model.Car;

public interface CarMapper {
	
	Car dtoToModel(CarDTO dto);
	
	CarDTO modelToDto(Car model);
	
	List<Car> dtoToModel(List<CarDTO> dtos);
	
	List<CarDTO> modelToDto(List<Car> models);
	
	Class<? extends CarDTO> dtoClazz();
	
	Class<? extends Car> modelClazz();
}
