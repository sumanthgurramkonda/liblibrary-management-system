package com.library.librarymanaegmentsystem.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.librarymanaegmentsystem.dto.BookDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Students",
uniqueConstraints = @UniqueConstraint(columnNames = { "rollNumber" }) )
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "rollNumber" )
	private long rollNumber;
	private String firstName;
	private String lastName;
	private String mail;
	private long mobileNumber;
	@OneToMany(mappedBy = "id",fetch = FetchType.EAGER, 
			   cascade = {CascadeType.PERSIST, CascadeType.MERGE,
		                  CascadeType.DETACH, CascadeType.REFRESH})
	@JsonIgnore
	private List<Book> books;
	
	@Transient
	private List<BookDto> bookDtos;
	
	public Student() {
		
	}
	public Student(long id, long rollNumber, String firstName, String lastName, String mail, long mobileNumber,
			List<Book> books) {
		super();
		this.id = id;
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.mobileNumber = mobileNumber;
		this.books = books;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(long rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMmail() {
		return mail;
	}
	public void setMail(String email) {
		this.mail = email;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public List<BookDto> getBookDtos() {
		return bookDtos;
	}
	public void setBookDtos(List<BookDto> bookDtos) {
		this.bookDtos = bookDtos;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", rollNumber=" + rollNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", mail=" + mail + ", mobileNumber=" + mobileNumber + ", books=" + books + "]";
	}

}
