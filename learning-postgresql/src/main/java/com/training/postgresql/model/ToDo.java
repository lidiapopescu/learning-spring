package com.training.postgresql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Table is automatically created if missing
 * LOG: Hibernate: create table todo (id int4 not null, description varchar(255), summary varchar(255), title varchar(255), primary key (id))
 * */
@Entity
@Table(name="todo")
public class ToDo {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	Integer id;
	String title;
	String summary;
	String description;
	
	public ToDo() {}
	
	public ToDo(Integer id, String title, String summary, String description) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.description = description;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
