package com.authorsAndBooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.authorsAndBooks.model.Author;
import com.authorsAndBooks.service.AuthorService;

@Controller
public class AuthorsController {
	
	@Autowired
	AuthorService service;
	
	@PostMapping("/insertAuthor")
	public String insert(Author author) {
		service.insert(author);
		
		return "index";
	}
	
	@GetMapping("/searchByName")
	private ModelAndView search(@RequestParam String name) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("listAuthors");
		List<Author> authors = service.searchByName(name);
		modelAndView.addObject("authors", authors);
		return modelAndView;
	}
}
