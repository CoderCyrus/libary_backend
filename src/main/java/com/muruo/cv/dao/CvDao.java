package com.muruo.cv.dao;

import java.util.List;

import com.muruo.cv.model.Book;

//Interface 
public interface CvDao {

	Integer getCountCv();

	Book findBookById(int id);

	List<Book> getBooks();

	List<Book> findBooksNotBorrowed();
	
	void updateBookBorrowed(int id);

	void updateBookAvailable(int id);

	String findBookNameById(int id);

}
