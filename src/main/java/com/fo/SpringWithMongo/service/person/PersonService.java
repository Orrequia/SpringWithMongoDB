package com.fo.SpringWithMongo.service.person;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.fo.SpringWithMongo.model.Person;

public interface PersonService {

	List<Person> findAll(Pageable pageable);
	
	Optional<Person> findById(String idPerson);
	
	Optional<Person> findByUsername(String username);
	
	Person create(Person person);
	
	void update(Person person);
	
	void delete(Person person);
}
