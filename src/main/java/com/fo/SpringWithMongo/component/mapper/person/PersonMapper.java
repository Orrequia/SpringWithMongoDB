package com.fo.SpringWithMongo.component.mapper.person;

import java.util.List;

import com.fo.SpringWithMongo.dto.PersonDTO;
import com.fo.SpringWithMongo.model.Person;

public interface PersonMapper {

	Person dtoToModel(PersonDTO dto);
	
	PersonDTO modelToDto(Person model);
	
	List<Person> dtoToModel(List<PersonDTO> dtos);
	
	List<PersonDTO> modelToDto(List<Person> models);
	
	Class<? extends PersonDTO> dtoClazz();
	
	Class<? extends Person> modelClazz();
}
