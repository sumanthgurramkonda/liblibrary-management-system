package com.library.librarymanaegmentsystem.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.library.librarymanaegmentsystem.dto.BookDto;
import com.library.librarymanaegmentsystem.entity.Book;
import com.library.librarymanaegmentsystem.repository.BookRepositoty;

import jakarta.annotation.PostConstruct;

@Service
public class BookService {
	
	@Autowired
	private BookRepositoty bookRepositoty;
	private Iterable<Book> books;
    private List<BookDto> booksDto;
    
	public List<BookDto> getAllBooks(final int pageNumber, final int size) {
		booksDto = new ArrayList<>();
		books = bookRepositoty.findAll(PageRequest.of(pageNumber, size));
		books.forEach(book->{
			BookDto bookDto = new BookDto(book.getSerialId(),book.getTitle(), 
					                      book.getAuthor(),book.getCategory(), book.getCount());
			booksDto.add(bookDto);
		});
		return booksDto;
	}

	public void saveBook(Book book) {
		bookRepositoty.save(book);
	}
	
//	@PostConstruct
	public void sabeBooks() {
		for(int i=0;i<1000;i++) {
			bookRepositoty.save(new Book(i, 1000+i, "title "+i, "author "+i, 1000, 5, "category "+i));
		}
	}

	public List<BookDto> getBookByTitle(String title) {
		 booksDto = new ArrayList<>();
		 books = bookRepositoty.findByTitle(title);
		 booksDto = new ArrayList<>();
		 books.forEach(book->{
				BookDto bookDto = new BookDto(book.getSerialId(),book.getTitle(), 
						                      book.getAuthor(),book.getCategory(), book.getCount());
				booksDto.add(bookDto);
			});
		 return booksDto;
	}

	public void updateCount(long serialId,int count) {
		Book book = bookRepositoty.findBySerialId(serialId);
		book.setCount(count);
		bookRepositoty.save(book);
	}

	public Set<String> getCategory() {
		Set<String> categories = new LinkedHashSet<>();
		bookRepositoty.findAll().forEach(book->{
			categories.add(book.getCategory());
		});
		return categories;
	}

	public List<BookDto> getAllBooks() {
	    books = bookRepositoty.findAll();
	    booksDto = new ArrayList<>();
	    books.forEach(book->{
			BookDto bookDto = new BookDto(book.getSerialId(),book.getTitle(), 
					                      book.getAuthor(),book.getCategory(), book.getCount());
			booksDto.add(bookDto);
		});
		return booksDto;
	}

	public List<BookDto> getByValue(String val) {
		 booksDto = new ArrayList<>();
		 books = bookRepositoty.findByTitle(val);
		 if(books!=null) {
			   mapToBookDto(books,booksDto);
			 }
		 books =  bookRepositoty.findByAuthor(val);
		 if(books!=null) {
			   mapToBookDto(books,booksDto);
			 }
		 books = bookRepositoty.findByCategory(val);
		 if(books!=null) {
		   mapToBookDto(books,booksDto);
		 }
		 System.out.println(books);
		return booksDto;
	}
	
	public void mapToBookDto(Iterable<Book> books2, List<BookDto> booksDto){
		books2.forEach(book->{
			BookDto bookDto = new BookDto(book.getSerialId(),book.getTitle(), 
					                      book.getAuthor(),book.getCategory(), book.getCount());
			booksDto.add(bookDto);
		});
	}

}




