package com.bashayer.bookapi.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bashayer.bookapi.models.Book;
import com.bashayer.bookapi.service.BookService;

@Controller
public class BooksController {
	// ..

	    private final BookService bookService;
	    
	    public BooksController(BookService bookService){
	        this.bookService = bookService;
	    }
	    
	    
	    @RequestMapping("/books/{id}")
	    public String showOne(@PathVariable("id") Long id , Model model) {
	        Book book = bookService.findBook(id); //retrieve the book
	        model.addAttribute(book); // pass it to the show.jsp page to display it !!
	        
	        return "show.jsp";
	    }
	    
	    
	    
	}


