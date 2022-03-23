<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autores y libros</title>
</head>
<body>
	<form action="insertAuthorPage" method="get">
		<input type="submit" value="insertar autores"/>
	</form>
	<form action="insertBookPage" method="get">
		<input type="submit" value="insertar libros"/>
	</form>
	<form action="listAuthorPage" method="get">
		<input type="submit" value="lista de autores"/>
	</form>
	<form action="listBookPage" method="get">
		<input type="submit" value="lista de libros"/>
	</form>
</body>
</html>