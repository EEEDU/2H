package com.authorsAndBooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.authorsAndBooks.model.Book;
import com.authorsAndBooks.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	@PostMapping("/insertBook")
	public String insert( Book book) {
		bookService.insert(book);
		return "index";
	}
	
	@GetMapping("/searchByNameBook")
	private ModelAndView search(@RequestParam String name) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("listBooks");
		List<Book> books = bookService.searchByName(name);
		modelAndView.addObject("books", books);
		return modelAndView;
	}
}
