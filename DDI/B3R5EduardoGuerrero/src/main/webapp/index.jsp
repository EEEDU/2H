<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Inicio</title>
	</head>

	<body>
        <h2>ALUMNO</h2>
        <form action="/insertServletAlumno" method="post">
            <span>Name:</span> <input type="text" name="nombre">
            <span>Edad:</span> <input type="text" name="edad">
            <select name="curso">
                    <option>primero</option>
                    <option>segundo</option>
            </select>
            <input type="submit">
        </form>
        <form action="/list" method="post">
            <input type="submit" value="Listado">
        </form>
        <form action="/delete" method="post">
            <input type="submit" value="Borrar">
        </form>
    </body>

	</html>