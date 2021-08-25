package com.kvinod.mongodbtestdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.kvinod.mongodbtestdemo.entity.Person;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
public class MongoTemplateTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    void shouldAddNewPerson() {
        DBObject p1 = BasicDBObjectBuilder.start().add("_id", new ObjectId("61266b1e62fe0abe70548563"))
                .add("name", "Vinod").add("email", "vinod@vinod.co").add("phone", "9731424784").get();

        mongoTemplate.save(p1, "persons");

        Person p2 = mongoTemplate.findById(new ObjectId("61266b1e62fe0abe70548563"), Person.class);
        assertEquals("Vinod", p2.getName());
    }

}
