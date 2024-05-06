package com.library.librarymanaegmentsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.library.librarymanaegmentsystem.dto.BookDto;
import com.library.librarymanaegmentsystem.entity.Book;
import com.library.librarymanaegmentsystem.entity.Student;
import com.library.librarymanaegmentsystem.repository.BookRepositoty;
import com.library.librarymanaegmentsystem.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private BookRepositoty bookRepositoty;

	public void saveStudent(Student student) {
//		student.setBooks(bookRepositoty.findAll(PageRequest.of(0, 3)).getContent());
		studentRepository.save(student);
	}

	public Student getStudentBydRollNo(long rollNo) {

		Student student = studentRepository.findByRollNumber(rollNo);
		List<BookDto> bookDtos = new ArrayList<>();
		student.getBooks().forEach(book->{
			bookDtos.add(new BookDto(book.getSerialId(), book.getTitle(), book.getAuthor(),book.getCategory(), book.getCount()));
		});
	    student.setBookDtos(bookDtos);
	    return student;
	}
	public void addBooks(long rollNumber,List<Long> serialIds) {
		Student student = getStudentBydRollNo(rollNumber);
		final List<Book> books = new ArrayList<>();
		serialIds.forEach(serialNumber->{
			books.add(bookRepositoty.findBySerialId(serialNumber));
		});
		student.setBooks(books);
		studentRepository.save(student);
	}
}


