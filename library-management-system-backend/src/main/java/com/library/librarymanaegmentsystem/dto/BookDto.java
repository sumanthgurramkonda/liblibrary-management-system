package com.library.librarymanaegmentsystem.dto;

public class BookDto {
	
	private long serialId;
	private String title;
	private String author;
	private String category;
	private int count;
	
	public BookDto() {
		
	}
	
	public BookDto(long serialId, String title, String author,String category, int count) {
		super();
		this.serialId = serialId;
		this.title = title;
		this.author = author;
		this.category = category;
		this.count = count;
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
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BookDto [serialId=" + serialId + ", title=" + title + ", author=" + author + ", category=" + category
				+ ", count=" + count + "]";
	}

}
