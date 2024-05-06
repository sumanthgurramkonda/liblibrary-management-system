package com.library.librarymanaegmentsystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.library.librarymanaegmentsystem.dto.BookDto;
import com.library.librarymanaegmentsystem.entity.Book;

public interface BookRepositoty extends CrudRepository<Book, Long>,PagingAndSortingRepository<Book, Long>{

	List<Book> findByTitle(String title);

	Book findBySerialId(long serialId);

	Iterable<Book> findByAuthor(String author);

	Iterable<Book> findByCategory(String category);
	
	
}
