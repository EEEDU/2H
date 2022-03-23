package com.authorsAndBooks.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.authorsAndBooks.model.Author;

@Repository
public class AuthorRepository extends AbstractRepository {

	public void insert(Author author) {
		Connection conn = createConnection();

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Authors (name, dateOfBirth) VALUES (?, ?)");
			preparedStatement.setString(1, author.getName());
			preparedStatement.setString(2, author.getDateOfBirth());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			close(preparedStatement);
		}

		closeConnection(conn);
	}
	
	public List<Author> listAll() {
		List<Author> authors = new ArrayList<Author>();
		Connection con = createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			preparedStatement = con.prepareStatement("SELECT * FROM Authors");
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				Integer id = result.getInt(1);
				String authorName = result.getString(2);
				String dateOfBirth = result.getString(3);
				
				Author author = new Author(id, authorName, dateOfBirth);
				authors.add(author);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(result);
			close(preparedStatement);
			closeConnection(con);
		}
		return authors;
	}
	
	public List<Author> searchByName(String name) {
		List<Author> authors = new ArrayList<Author>();
		Connection con = createConnection();
		PreparedStatement preparedStatement = null;
		ResultSet result = null;
		
		try {
			preparedStatement = con.prepareStatement("SELECT * FROM Authors WHERE name = ?");
			preparedStatement.setString(1, name);
			result = preparedStatement.executeQuery();
			
			while(result.next()) {
				Integer id = result.getInt(1);
				String authorName = result.getString(2);
				String dateOfBirth = result.getString(3);
				
				Author author = new Author(id, authorName, dateOfBirth);
				authors.add(author);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(result);
			close(preparedStatement);
			closeConnection(con);
		}
		return authors;
	}

}
