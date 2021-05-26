package com.example.hrspringbootwebtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrspringbootwebtest.model.Author;
import com.example.hrspringbootwebtest.repository.AuthorRepository;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@GetMapping(path="/author/{id}")
	public Author getAuthor(@PathVariable Long id) {
		return authorRepository.findById(id).orElse(null);
	}
	
	@PostMapping(path="/author")
	public Author createAuthor(@RequestBody Author author) {
		System.out.println("****" + author);
		authorRepository.save(author);
		return author;
	}
}
