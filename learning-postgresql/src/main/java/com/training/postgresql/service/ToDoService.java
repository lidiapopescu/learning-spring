package com.training.postgresql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.training.postgresql.model.ToDo;
import com.training.postgresql.repository.ToDoRepository;

@Service
public class ToDoService {
	
	private ToDoRepository toDoRepository;

	public ToDoService(ToDoRepository toDoRepository) {
		super();
		this.toDoRepository = toDoRepository;
	}

	/**
	 * Automatically executed:
	 * Hibernate: select todo0_.id as id1_1_, todo0_.description as descript2_1_, todo0_.summary as summary3_1_, todo0_.title as title4_1_ from todo todo0_
	 * */
	public List<ToDo> getAllToDos() {
		List<ToDo> todos = new ArrayList<ToDo>();
		toDoRepository.findAll().forEach(todos::add);
		return todos;
	}
	
	public Optional<ToDo> getToDo(Integer id) {
		return toDoRepository.findById(id);
	}
		
	public void createToDo(ToDo todo) {
		toDoRepository.save(todo);
	}
	
	public void updateToDo(Integer id, ToDo todo) {
		toDoRepository.save(todo);
	}
	
	public void deleteToDo(Integer id) {
		toDoRepository.deleteById(id);
	}
}
