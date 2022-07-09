package com.training.postgresql.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.postgresql.model.Person;
import com.training.postgresql.repository.PersonRepository;

@RestController
@RequestMapping("person")
public class PersonController {

	private PersonRepository personRepository;
	
	public PersonController(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	@PostMapping("person")
	public String createPerson(@RequestParam String name) {
		personRepository.save(new Person(name, "Romania"));
		return personRepository.findByName(name) + " Savend Successfully";
	}
	
	@GetMapping("person")
	public List<Person> getAllThePeople() {
		return personRepository.findAll();
	}
}
