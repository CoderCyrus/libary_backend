package com.muruo.cv.model;


public class AddBookDetails {
	
	public AddBookDetails(int id, String name, String description, String date_borrow, String date_return, int state,
			int times) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.date_borrow = date_borrow;
		this.date_return = date_return;
		this.state = state;
		this.times = times;
	}
	
	public AddBookDetails(){
		
	}
	private int id;
	private String name;
	private String description;
	private String date_borrow;
	private String date_return;
	private int state;
	private int times;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate_borrow() {
		return date_borrow;
	}
	public void setDate_borrow(String date_borrow) {
		this.date_borrow = date_borrow;
	}
	public String getDate_return() {
		return date_return;
	}
	public void setDate_return(String date_return) {
		this.date_return = date_return;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}

	
}
