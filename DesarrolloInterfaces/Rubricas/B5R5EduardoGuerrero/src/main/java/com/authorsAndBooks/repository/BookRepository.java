package com.authorsAndBooks.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.authorsAndBooks.model.Book;

@Repository
public class BookRepository extends AbstractRepository {

	public void insert(Book book) {
		Connection conn = createConnection();

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO BOOKS (title, isbn, authorId) VALUES (?, ? ,?)");
			preparedStatement.setString(1, book.getTitle());
			preparedStatement.setString(2, book.getIsbn());
			preparedStatement.setInt(3, book.getAuthor());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		closeConnection(conn);
	}
	
	public List<Book> listAll() {
		List<Book> books = new ArrayList<Book>();
		Connection con = createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			preparedStatement = con.prepareStatement("SELECT * FROM BOOKS");
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				Integer id = result.getInt(1);
				String title = result.getString(2);
				String isbn = result.getString(3);
				Integer authorID = result.getInt(4);
				
				Book book = new Book(id, title, isbn, authorID);
				books.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(result);
			close(preparedStatement);
			closeConnection(con);
		}
		return books;
	}
	
	public List<Book> searchByName(String name) {
		List<Book> books = new ArrayList<Book>();
		Connection con = createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			preparedStatement = con.prepareStatement("SELECT * FROM AUTHORS WHERE ? = name");
			preparedStatement.setString(1, name);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				Integer id = result.getInt(1);
				String title = result.getString(2);
				String isbn = result.getString(3);
				Integer authorID = result.getInt(4);
				
				Book book = new Book(id, title, isbn, authorID);
				books.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(result);
			close(preparedStatement);
			closeConnection(con);
		}
		return books;
	}

}