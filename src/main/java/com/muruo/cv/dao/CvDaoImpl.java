package com.muruo.cv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.muruo.cv.model.Book;

// Dao : data access object
@Component
public class CvDaoImpl implements CvDao {
	
	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public Integer getCountCv() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String mysql = "SELECT COUNT(*) FROM LIBRARY;";
		Integer nbToto = jdbcTemplate.queryForObject(mysql, Integer.class);
		return nbToto;
	}

	@Override
	public List<Book> getBooks() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String mySql = "SELECT * FROM LIBRARY;";
		List<Book> libraies = jdbcTemplate.query(mySql, new BookRowMapper());
		return libraies;
	}

	@Override
	public Book findBookById(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String mySql = "SELECT * FROM LIBRARY where id = ?;";
		Book book = jdbcTemplate.queryForObject(mySql, new Object[] {id}, new BookRowMapper());	
		return book;
	}

	@Override
	public List<Book> findBooksNotBorrowed() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String mySql = "SELECT * FROM LIBRARY WHERE state = 0;";
		List<Book> notborrowed = jdbcTemplate.query(mySql, new BookRowMapper());
		return notborrowed;
	}
	
	@Override
	public void updateBookBorrowed(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String mySql = "update library set state = 1 where id = ?;";
		jdbcTemplate.update(mySql, new Object[] {id});
	}
	
	@Override
	public void updateBookAvailable(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String mySql = "update library set state = 0 where id = ?;";
		jdbcTemplate.update(mySql, new Object[] {id});
	}
	
	@Override
	public String findBookNameById(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String mySql = "SELECT name FROM LIBRARY where id = ?;";
		String name = jdbcTemplate.queryForObject(mySql, new Object[] {id}, String.class);	
		return name;
	}

	public class BookRowMapper implements RowMapper<Book> {
		@Override
		public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
			Book library = new Book();
			library.setId(rs.getInt("id"));
			library.setName(rs.getString("name"));
			library.setDescription(rs.getString("description"));
			library.setDate_borrow(rs.getString("date_borrow"));
			library.setDate_return(rs.getString("date_return"));
			library.setState(rs.getInt("state"));
			library.setTimes(rs.getInt("times"));
			return library;
		}
	}

}
