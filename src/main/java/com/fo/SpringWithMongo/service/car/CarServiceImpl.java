package com.fo.SpringWithMongo.service.car;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fo.SpringWithMongo.dao.CarDAO;
import com.fo.SpringWithMongo.model.Car;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarDAO carDAO;
	
	@Override
	public List<Car> findAll(Pageable pageable) {
		return carDAO.findAll(pageable).stream().collect(Collectors.toList());
	}

	@Override
	public Optional<Car> findById(String idCar) {
		return carDAO.findById(idCar);
	}

	@Override
	public Car create(Car car) {
		return carDAO.save(car);
	}

	@Override
	public void update(Car car) {
		carDAO.save(car);	
	}

	@Override
	public void delete(Car car) {
		carDAO.delete(car);		
	}
}
