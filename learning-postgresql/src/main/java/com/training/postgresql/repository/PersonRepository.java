package com.training.postgresql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.postgresql.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	@Query("SELECT name FROM Person p WHERE p.name LIKE %:personName%")
	String findByName(String personName);
}
