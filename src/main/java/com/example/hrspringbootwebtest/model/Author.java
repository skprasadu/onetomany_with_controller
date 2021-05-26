package com.example.hrspringbootwebtest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "authors")
public class Author {
	
	public Author(Long id, String name) {
		this.authorId = id;
		this.name = name;
	}
	
	public Author() {
		
	}

	@Id
	private Long authorId;
	private String name;
	
	//TODO: uncomment this to make 1 stretch test createProjectEmployeeAPI, this implement one to many
	@OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Book> books = new ArrayList<>();
}