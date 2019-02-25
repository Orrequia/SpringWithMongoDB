package com.fo.SpringWithMongo.service.car;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.fo.SpringWithMongo.model.Car;

public interface CarService {

	List<Car> findAll(Pageable pageable);
	
	Optional<Car> findById(String idCar);
	
	Car create(Car car);
	
	void update(Car car);
	
	void delete(Car car);
}
