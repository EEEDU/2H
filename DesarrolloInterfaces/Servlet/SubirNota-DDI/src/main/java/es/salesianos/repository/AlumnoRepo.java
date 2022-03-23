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

public class AlumnoRepo implements Repo<Alumno> {

	private final AbstractConnection manager = new H2Connection();


	@Override
	public List<Alumno> findAll() {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;
		List<Alumno> alumnosList = new ArrayList<>();

		try {
			statement = conn.prepareStatement("SELECT * FROM ALUMNOS");
			ResultSet rs = statement.executeQuery();

			Repo<Clase> titulacionRepo = new ClaseRepo();

			while (rs.next()) {

				Alumno a = new Alumno();
				a.setId(rs.getInt("id"));
				a.setNombre(rs.getString("nombre"));
				a.setVoto(rs.getInt("voto"));
				a.setClase(rs.getInt("clase"));
				alumnosList.add(a);
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}

		return alumnosList;
	}

	@Override
	public void update(Alumno alumno) {

		Connection conn = manager.open(JDBC_URL);
		PreparedStatement statement = null;

		try {
			statement = conn.prepareStatement("UPDATE ALUMNOS SET VOTO = ? WHERE ID = ?");
			statement.setInt(1, alumno.getVoto());
			statement.setInt(4, alumno.getId());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {

			manager.close(statement);
			manager.close(conn);
		}
	}

	@Override
	public Alumno findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

}

