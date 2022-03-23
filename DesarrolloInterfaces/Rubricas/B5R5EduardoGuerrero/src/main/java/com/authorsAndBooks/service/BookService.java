package com.authorsAndBooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authorsAndBooks.model.Book;
import com.authorsAndBooks.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository repository;
	
	public void insert(Book book) {
		repository.insert(book);
	}
	
	public List<Book> searAll() {
		return repository.listAll();
	}
	
	public List<Book> searchByName(String name){
		return repository.searchByName(name);
	}
}
