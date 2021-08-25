package com.kvinod.mongodbtestdemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "persons")
@Data
public class Person {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String city;
}
