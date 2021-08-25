package com.kvinod.mongodbtestdemo.repository;

import com.kvinod.mongodbtestdemo.entity.Person;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
}
