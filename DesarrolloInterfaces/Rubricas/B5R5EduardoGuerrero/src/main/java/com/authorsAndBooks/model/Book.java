package com.authorsAndBooks.model;

public class Book {
	private Integer id;
	private String title;
	private String isbn;
	private Integer author;

	public Book(Integer id, String title, String isbn, Integer author) {
		this.id= id;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
	}

	public Book() {
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}

	
}
