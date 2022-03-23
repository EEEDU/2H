package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.AbstractConnection;
import es.salesianos.connection.H2Connection;
import es.salesianos.entities.Alumno;
import es.salesianos.entities.Clase;

public class ClaseRepo implements Repo<Clase> {

	AbstractConnection manager = new H2Connection();


	@Override
	public List<Clase> findAll() {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;
		List<Clase> Clase = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT * FROM Clase");
			ResultSet rs = statement.executeQuery();
			Repo<Alumno> alumnoRepo = new AlumnoRepo();

			while (rs.next()) {


				Clase t = new Clase();
				t.setId(rs.getInt("id"));
				t.setNombre(rs.getString("nombre"));
				Clase.add(t);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

		return Clase;
	}


	@Override
	public Clase findById(Integer id) {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;
		Clase Clase = new Clase();

		try {
			statement = conn.prepareStatement("SELECT * FROM Clase WHERE ID = ?");
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Clase.setId(rs.getInt("id"));
				Clase.setNombre(rs.getString("nombre"));
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

		return Clase;
	}


	@Override
	public void update(Clase t) {
		// TODO Auto-generated method stub
		
	}
}