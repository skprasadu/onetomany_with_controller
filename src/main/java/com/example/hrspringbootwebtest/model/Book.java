package com.example.hrspringbootwebtest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "books")
public class Book {
	
	@Id
	private Long bookId;
	
	private String name;
}
