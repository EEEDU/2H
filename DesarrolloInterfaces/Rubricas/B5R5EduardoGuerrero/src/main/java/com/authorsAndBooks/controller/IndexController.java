package com.authorsAndBooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/insertAuthorPage")
	public String insertAuthorPage() {
		return "insertAuthor";
	}
	
	@GetMapping("/insertBookPage")
	public String insertBookPage() {
		return "insertBook";
	}
	
	@GetMapping("/listAuthorPage")
	public String listAuthorPage() {
		return "listAuthors";
	}
	
	@GetMapping("/listBookPage")
	public String listBookPage() {
		return "listBooks";
	}
}
