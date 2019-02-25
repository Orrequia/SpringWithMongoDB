package com.fo.SpringWithMongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fo.SpringWithMongo.component.mapper.car.CarMapper;
import com.fo.SpringWithMongo.dto.CarDTO;
import com.fo.SpringWithMongo.model.Car;
import com.fo.SpringWithMongo.service.car.CarService;

@RestController
@RequestMapping(value="/car")
public class CarController {

	@Autowired
	private CarService carService;
	
	@Autowired
	private CarMapper carMapper;
	
	@GetMapping
	public List<CarDTO> getAll(@RequestParam(defaultValue = "0", required= false ) Integer page, 
			 					@RequestParam(defaultValue = "10", required= false ) Integer size) {
		return carMapper.modelToDto(carService.findAll(PageRequest.of(page,  size)));
	}
	
	@GetMapping("/{idCar}")
	public CarDTO getById(@PathVariable("idCar") String id) {
		return carMapper.modelToDto(carService.findById(id).get());
	}
	
	@PostMapping
	public CarDTO create(@RequestBody CarDTO carDTO) {
		return carMapper.modelToDto(carService.create(carMapper.dtoToModel(carDTO)));
	}
	
	@PutMapping("/{idCar}")
	public void update(@RequestBody CarDTO carDTO, 
					@PathVariable("idCar") String id) {
		Optional<Car> car = carService.findById(id);
		car.get().setLicensePlate(carDTO.getLicensePlate());
		car.get().setModel(carDTO.getModel());
		car.get().setBrand(carDTO.getBrand());
		carService.update(car.get());
	}
	
	@DeleteMapping("/{idCar}")
	public void delete(@PathVariable("idCar") String id) {
		carService.delete(carService.findById(id).get());
	}
}