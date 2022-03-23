<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar Autor</title>
</head>
<body>
	<form:form action="insertAuthor" method="post" modelAttribute="author">
		<span>Nombre del autor</span>
		<form:input type="text" name="name" path="name"/>
		
		<br>
		
		<span>Fecha de nacimiento (dd/mm/aaaa)</span>
		<form:input type="text" name="dateOfBirth" path="dateOfBirth"/>
		
		<br>
		
		<input type="submit" value="Insertar el Autor"/>
	</form:form>
</body>
</html>