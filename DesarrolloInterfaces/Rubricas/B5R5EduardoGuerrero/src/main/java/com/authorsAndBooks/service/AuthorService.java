package com.authorsAndBooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authorsAndBooks.model.Author;
import com.authorsAndBooks.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository repository;
	
	public void insert(Author author) {
		repository.insert(author);
	}
	
	public List<Author> searchAll() {
		return repository.listAll();
	}
	
	public List<Author> searchByName(String name) {
		return repository.searchByName(name);
	}
}
