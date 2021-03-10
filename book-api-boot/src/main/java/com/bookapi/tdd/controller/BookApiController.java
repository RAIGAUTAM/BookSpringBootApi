package com.bookapi.tdd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapi.tdd.entity.Book;
import com.bookapi.tdd.exception.BookNotFound;
import com.bookapi.tdd.exception.BookPriceNotAllowed;
import com.bookapi.tdd.repository.BookRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bookapi")
public class BookApiController {
	
	@Autowired
	BookRepository bookRepo;
	
	@GetMapping("/search")
	public List<Book> getAllBooks() {
	    return bookRepo.findAll();
	}
	
	@PostMapping("/update")
	public Book createBook(@RequestBody Book book) {
	    return bookRepo.save(book);
	}
	
	@GetMapping("/search/{id}")
	public Book getBookById(@PathVariable(value = "id") Long bookId) {
	    return bookRepo.findById(bookId).orElseThrow(() -> new BookNotFound("Book", "id", bookId));
	}
	
	@PutMapping("/update/{id}")
	public Book updateBook(@PathVariable(value = "id") Long bookId,
	                                        @RequestBody Book bookDetails) {

	    bookRepo.findById(bookId).orElseThrow(() -> new BookNotFound("Book", "id", bookId));
	    bookDetails.setBookId(bookId);
	    if(bookDetails.getBookPrice()>2000) {
	    	throw new BookPriceNotAllowed("Book", "price", bookDetails.getBookPrice());
	    }
	    Book updateBook = bookRepo.save(bookDetails);
	    return updateBook;
	}
	
	@DeleteMapping("/update/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) {
	    Book book = bookRepo.findById(bookId).orElseThrow(() -> new BookNotFound("Book", "id", bookId));

	    bookRepo.delete(book);
	    return ResponseEntity.ok().build();
	}
	
	

}
