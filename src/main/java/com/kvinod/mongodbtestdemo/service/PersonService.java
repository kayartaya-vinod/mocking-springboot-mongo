package com.kvinod.mongodbtestdemo.service;

import java.util.Optional;

import com.kvinod.mongodbtestdemo.entity.Person;
import com.kvinod.mongodbtestdemo.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repo;

    public Iterable<Person> getAllPersons() {
        return repo.findAll();
    }

    public Person addNewPerson(Person person) {
        return repo.save(person);
    }

    public Person getById(String id) {
        Optional<Person> op = repo.findById(id);
        if (op.isPresent()) {
            return op.get();
        } else {
            return null;
        }
    }
}
