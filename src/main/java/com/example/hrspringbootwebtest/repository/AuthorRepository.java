package com.example.hrspringbootwebtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrspringbootwebtest.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {


}
