package com.fo.SpringWithMongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fo.SpringWithMongo.model.Car;

@Repository
public interface CarDAO extends MongoRepository<Car, String> {

}
