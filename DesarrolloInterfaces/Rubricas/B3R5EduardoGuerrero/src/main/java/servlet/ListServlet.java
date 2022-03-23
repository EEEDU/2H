package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet {
    private String jdbcUrl = "jdbc:h2:file:~/testdb";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
            preparedStatement = conn.prepareStatement("SELECT nombre, edad, curso FROM ALUMNO");
            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<String> listNombres = new ArrayList<String>();
            ArrayList<Integer> listEdades = new ArrayList<Integer>();
            ArrayList<String> listCurso = new ArrayList<String>();
            while (resultSet.next()) {
                String string = resultSet.getString(1);
                listNombres.add(string);
                Integer integer = resultSet.getInt(2);
                listEdades.add(integer);
                String string2 = resultSet.getString(3);
                listCurso.add(string2);

            }
            request.setAttribute("nombres", listNombres);
            request.setAttribute("edades", listEdades);
            request.setAttribute("titulaciones", listCurso);
            preparedStatement.close();
            conn.close();
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
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/list.jsp");
        dispatcher.forward(request, response);
    }

}
