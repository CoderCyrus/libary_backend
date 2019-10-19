package com.muruo.cv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.muruo.cv.dao.CvDao;
import com.muruo.cv.model.Book;
import com.muruo.cv.model.Cv;

@RestController
@CrossOrigin(origins = "*")
public class CVController {

	@Autowired
	private CvDao cvDao;

	private static final String CV_URL = "/muruo/cv";
	private static final String CV_COUNT_URL = "/muruo/count";
	private static final String CV_TABLE_URL = "/muruo/table";
	private static final String CV_FIND_ONE_URL = "/muruo/find";
	private static final String CV_FIND_ONE_NAME_URL = "/muruo/find/name";
	private static final String CV_FIND_NOT_BORROWED_URL = "/muruo/notborrowed";
	private static final String CV_UPDATE_A_BOOK = "/muruo/updateabook/{id}";

	// Méthode Get : un objet CV
	@GetMapping(path = CV_URL)
	public ResponseEntity<Cv> getCv() {
		Cv cv = new Cv();
		cv.setNom("Muruo");
		ResponseEntity<Cv> responseEntity = ResponseEntity.ok(cv);
		return responseEntity;
	}

	// Count the number of books in the library
	@GetMapping(path = CV_COUNT_URL)	
	public ResponseEntity<Integer> getCountCv() {
		Integer count = cvDao.getCountCv();
		ResponseEntity<Integer> responseEntity = ResponseEntity.ok(count);
		return responseEntity;
	}

	// Get all libraries
	@GetMapping(path = CV_TABLE_URL)
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> libraries = cvDao.getBooks();
		ResponseEntity<List<Book>> responseEntity = ResponseEntity.ok(libraries);
		return responseEntity;
	}

	// Get one book from database
	@GetMapping(path = CV_FIND_ONE_URL)
	public ResponseEntity<Book> findBookById(@RequestParam(value = "id") int id) {
		Book book = cvDao.findBookById(id);
		ResponseEntity<Book> responseEntity = ResponseEntity.ok(book);
		return responseEntity;

	}
	
	// Get one book from database
	@GetMapping(path = CV_FIND_ONE_NAME_URL)
	public ResponseEntity<String> findBookNameById(@RequestParam(value = "id") int id) {
		String name = cvDao.findBookNameById(id);
		ResponseEntity<String> responseEntity = ResponseEntity.ok(name);
		return responseEntity;
	}

	// Find books not borrowed
	@GetMapping(path = CV_FIND_NOT_BORROWED_URL)
	public ResponseEntity<List<Book>> findBooksNotBorrowed() {
		List<Book> booksnotborrowed = cvDao.findBooksNotBorrowed();
		ResponseEntity<List<Book>> responseEntity = ResponseEntity.ok(booksnotborrowed);
		return responseEntity;
	}

	// Update one book information
	@PostMapping(path=CV_UPDATE_A_BOOK)
	public void updateBookBorrowed(@PathVariable int id) {
		cvDao.updateBookBorrowed(id);
	}
}
