package com.B2R4EduardoGuerrero.jdbc.ddl.example;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.text.html.parser.DTDConstants;

import org.apache.log4j.Logger;
 
public class JdbcDdlExample implements DTDConstants {
 
    // JDBC Driver Name & Database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String JDBC_DB_URL = "jdbc:mysql://localhost:3306";
 
    // JDBC Database Credentials
    static final String JDBC_USER = "root";
    static final String JDBC_PASS = "";
 
    public final static Logger logger = Logger.getLogger(JdbcDdlExample.class);
 
    public static void main(String[] args) {
 
        Connection connObj = null;
        Statement stmtOBj = null;
        try {
            Class.forName(JDBC_DRIVER);
            connObj = DriverManager.getConnection(JDBC_DB_URL, JDBC_USER, JDBC_PASS);
 
            stmtOBj = connObj.createStatement();
 
            // DDL Statement 1 - Create Database Schema!
            logger.info("\n=======CREATE " + "alumnos" + " DATABASE=======");           
            stmtOBj.executeUpdate("UPDATE alumnos");
            logger.info("\n=======DATABASE IS SUCCESSFULLY CREATED=======\n");
 
            
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        } finally {
            try {
                if(stmtOBj != null) {
                    stmtOBj.close();    // Close Statement Object
                }
                if(connObj != null) {
                    connObj.close();    // Close Connection Object
                }
            } catch (Exception sqlException) {
                sqlException.printStackTrace();
            }
        }
    }
 
    // This Method Is Used To Print The Table Structure
    private static void showDbTableStructure() throws SQLException {
        StringBuilder builderObj = new StringBuilder();
        DatabaseMetaData metaObj = DriverManager.getConnection(JDBC_DB_URL, JDBC_USER, JDBC_PASS).getMetaData();
        ResultSet resultSetObj = metaObj.getColumns("alumnos", null, "clase", "%");
 
        builderObj.append("clase" + " Columns Are?= (");
        while (resultSetObj.next()) {
            String columnName = resultSetObj.getString(4);
            builderObj.append(columnName).append(", ");
        }
        builderObj.deleteCharAt(builderObj.lastIndexOf(",")).deleteCharAt(builderObj.lastIndexOf(" ")).append(")").append("\n");
        logger.info(builderObj.toString());
    }
}
