package com.fo.SpringWithMongo.service.person;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fo.SpringWithMongo.dao.PersonDAO;
import com.fo.SpringWithMongo.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDAO personDAO;
	
	@Override
	public List<Person> findAll(Pageable pageable) {
		return personDAO.findAll(pageable).stream().collect(Collectors.toList());
	}

	@Override
	public Optional<Person> findById(String idPerson) {
		return personDAO.findById(idPerson);
	}

	@Override
	public Optional<Person> findByUsername(String username) {
		return personDAO.findOneByUsername(username);
	}

	@Override
	public Person create(Person person) {
		return personDAO.save(person);
	}

	@Override
	public void update(Person person) {
		personDAO.save(person);
	}

	@Override
	public void delete(Person person) {
		personDAO.delete(person);		
	}
}
