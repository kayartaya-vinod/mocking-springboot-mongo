package com.kvinod.mongodbtestdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import com.kvinod.mongodbtestdemo.entity.Person;
import com.kvinod.mongodbtestdemo.repository.PersonRepository;
import com.kvinod.mongodbtestdemo.service.PersonService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class MongodbTestDemoApplicationTests {

	@MockBean
	PersonRepository repository;

	@Autowired
	PersonService service;

	Person p1;

	@BeforeEach
	void setup() {
		p1 = new Person();
		p1.setId("abc123");
		p1.setName("Vinod");
		p1.setEmail("vinod@vinod.co");
		p1.setPhone("9731424784");
		p1.setCity("Bangalore");

		Mockito.when(repository.findById("abc123")).thenReturn(Optional.of(p1));
		Mockito.when(repository.findById("bcd123")).thenReturn(Optional.empty());
	}

	@Test
	void shouldGetPersonById() {
		Person p = service.getById("abc123");
		assertEquals("Vinod", p.getName());
		assertEquals("vinod@vinod.co", p.getEmail());
		assertEquals("9731424784", p.getPhone());
		assertEquals("Bangalore", p.getCity());
	}

	@Test
	void shouldGetNullForInvalidId() {
		Person p = service.getById("bcd123");
		assertNull(p);
	}
}
