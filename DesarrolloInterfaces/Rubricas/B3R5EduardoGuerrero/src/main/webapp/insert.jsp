<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="ISO-8859-1">
			<title>Alumno</title>
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
			</form>
			<form action="/list" method="post">
				<input type="submit" value="Listado">
			</form>
			<form action="/delete" method="post">
				<input type="submit" value="Borrar">
			</form>
		</body>

		</html>