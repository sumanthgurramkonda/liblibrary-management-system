package com.library.librarymanaegmentsystem.dto;

import java.util.Set;

public class Category {
	
	private Set<String> category ;
	
	public Category() {
		
	}

	public Category(Set<String> category) {
		super();
		this.category = category;
	}


	public Set<String> getCategory() {
		return category;
	}

	public void setCategory(Set<String> category) {
		this.category = category;
	}

}
