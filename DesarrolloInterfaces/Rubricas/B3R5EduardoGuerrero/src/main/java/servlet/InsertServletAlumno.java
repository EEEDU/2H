package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertServletAlumno extends HttpServlet {
    private String jdbcUrl = "jdbc:h2:file:~/testdb";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String curso = req.getParameter("curso");
        int edad = Integer.parseInt(req.getParameter("edad"));


        Connection conn;
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(jdbcUrl, "sa", "");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement("create table IF NOT EXISTS ALUMNO(\r\n"
                    + "id bigint auto_increment,\r\n" + "nombre varchar(25),\r\n" + "edad integer,\r\n" + "curso varchar(25)\r\n" + ");");
            preparedStatement.executeUpdate();
            preparedStatement.close();
            preparedStatement = conn.prepareStatement("INSERT INTO ALUMNO (nombre, edad, curso) VALUES (?, ?, ?)");
            preparedStatement.setString(1, nombre);
            preparedStatement.setInt(2, edad);
            preparedStatement.setString(3, curso);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/insert.jsp");
        dispatcher.forward(req, resp);
    }
}
