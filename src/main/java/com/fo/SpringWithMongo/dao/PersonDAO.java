package com.fo.SpringWithMongo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.fo.SpringWithMongo.model.Person;

@Repository
public interface PersonDAO extends MongoRepository<Person, String> {

	public Optional<Person> findOneByUsername(String username);
	
	@Query("{Person.Car.idCar: ?0}")
	public List<Person> findByIdCar(String idCar);
}
