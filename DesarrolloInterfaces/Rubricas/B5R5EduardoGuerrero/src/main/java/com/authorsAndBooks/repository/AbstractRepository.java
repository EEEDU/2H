package com.authorsAndBooks.repository;

import com.authorsAndBooks.connection.AbstractConnection;
import com.authorsAndBooks.connection.ConnectionH2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AbstractRepository {
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	private AbstractConnection manager = new ConnectionH2();

	public Connection createConnection() {
		return manager.open(jdbcUrl);
	}

	public void closeConnection(Connection conn) {
		manager.close(conn);
	}

	public void close(PreparedStatement prepareStatement) {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	public void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
