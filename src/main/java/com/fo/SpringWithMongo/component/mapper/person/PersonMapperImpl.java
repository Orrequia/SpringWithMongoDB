package com.fo.SpringWithMongo.component.mapper.person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fo.SpringWithMongo.dto.PersonDTO;
import com.fo.SpringWithMongo.model.Person;

@Component
public class PersonMapperImpl implements PersonMapper {
	
	@Autowired
	public DozerBeanMapper dozer;
	
	@Override
	public Class<? extends PersonDTO> dtoClazz() {
		return PersonDTO.class;
	}

	@Override
	public Class<? extends Person> modelClazz() {
		return Person.class;
	}
	
	@Override
	public Person dtoToModel(PersonDTO dto) {
		return dozer.map(dto, modelClazz());
	}

	@Override
	public PersonDTO modelToDto(Person model) {
		return dozer.map(model, dtoClazz());
	}

	@Override
	public List<Person> dtoToModel(List<PersonDTO> dtos) {
		List<Person> models = new ArrayList<Person>();
		if(dtos != null) 
			for(PersonDTO dto : dtos)
				models.add(dtoToModel(dto));
		return models;
	}

	@Override
	public List<PersonDTO> modelToDto(List<Person> models) {
		return models.stream().map(m -> modelToDto(m)).collect(Collectors.toList());
	}
}
