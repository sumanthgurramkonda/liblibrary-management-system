package com.library.librarymanaegmentsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Books",
uniqueConstraints = @UniqueConstraint(columnNames = { "serialId" }) )
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column( name="serialId")
	private long serialId;
	private String title;
	private String author;
	private int cost;
	private int count;
	private String category;
	
	public Book() {
		
	}
	
	public Book(long id, long serialId, String title, String author, int cost, int count, String category) {
		super();
		this.id = id;
		this.serialId = serialId;
		this.title = title;
		this.author = author;
		this.cost = cost;
		this.count = count;
		this.category = category;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSerialId() {
		return serialId;
	}
	public void setSerialId(long serialId) {
		this.serialId = serialId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", serialId=" + serialId + ", title=" + title + ", author=" + author + ", cost="
				+ cost + ", count=" + count + ", category=" + category + "]";
	}
	
}
