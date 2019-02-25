package com.fo.SpringWithMongo.component.mapper.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fo.SpringWithMongo.dto.CarDTO;
import com.fo.SpringWithMongo.model.Car;

@Component
public class CarMapperImpl implements CarMapper {
	@Autowired
	public DozerBeanMapper dozer;
	
	@Override
	public Class<? extends CarDTO> dtoClazz() {
		return CarDTO.class;
	}

	@Override
	public Class<? extends Car> modelClazz() {
		return Car.class;
	}
	
	@Override
	public Car dtoToModel(CarDTO dto) {
		return dozer.map(dto, modelClazz());
	}

	@Override
	public CarDTO modelToDto(Car model) {
		return dozer.map(model, dtoClazz());
	}

	@Override
	public List<Car> dtoToModel(List<CarDTO> dtos) {
		List<Car> models = new ArrayList<Car>();
		if(dtos != null) 
			for(CarDTO dto : dtos)
				models.add(dtoToModel(dto));
		return models;
	}

	@Override
	public List<CarDTO> modelToDto(List<Car> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}
}
