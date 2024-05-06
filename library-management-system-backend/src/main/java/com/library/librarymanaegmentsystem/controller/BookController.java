package com.library.librarymanaegmentsystem.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.library.librarymanaegmentsystem.dto.BookDto;
import com.library.librarymanaegmentsystem.entity.Book;
import com.library.librarymanaegmentsystem.service.BookService;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {
	
	@Autowired
	private BookService bookService;

	@PostMapping("/save")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public void saveBook(@RequestBody Book book) {
		bookService.saveBook(book);
	}
	@GetMapping("/getByVal")
	@ResponseStatus(value = HttpStatus.OK)
	public List<BookDto> getBooksByValue(@RequestParam("val") String val){	
		return bookService.getByValue(val);
	}
	
	@GetMapping("/category")
	@ResponseStatus(value = HttpStatus.OK)
	public Set<String> getCategory(){
		return bookService.getCategory();
	}
	
	@GetMapping("/all")
	@ResponseStatus(value = HttpStatus.OK)
	public List<BookDto> getAllBooks(@RequestParam("pageNumber") final int pageNumber,
	                              @RequestParam("size") final int size){
		return bookService.getAllBooks(pageNumber, size);
	}
	
	@GetMapping("/allBooks")
	public List<BookDto>  getAllBooks(){
		return bookService.getAllBooks();
	}

	@GetMapping("/title/{title}")
	@ResponseStatus(value = HttpStatus.OK)
	public List<BookDto> getBooksByTitle(@PathVariable("title") String title){
		return bookService.getBookByTitle(title);
	}
	
	@PutMapping("/update/{serialId}/{count}")
	@ResponseStatus(value = HttpStatus.OK)
	public void updateBookCount(@PathVariable("serialId") long serialId,@PathVariable("count") int count) {
		bookService.updateCount(serialId,count);
	}
}











