package com.kvinod.mongodbtestdemo.controller;

import com.kvinod.mongodbtestdemo.entity.Person;
import com.kvinod.mongodbtestdemo.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public Iterable<Person> persons() {
        return service.getAllPersons();
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return service.addNewPerson(person);
    }
}
