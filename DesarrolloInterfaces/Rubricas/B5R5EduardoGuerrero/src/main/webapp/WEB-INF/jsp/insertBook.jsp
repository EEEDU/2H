<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<body>
	<form:form action="insertBook" method="post" modelAttribute="book">
		<span>titulo</span>
		<form:input type="text" name="title" path="title"/>
		
		<br>
		
		<span>Isbn</span>
		<input type="text" name="dateOfBirth" path="dateOfBirth"/>
		
		<br>
		
		<form:input type="submit" value="Insertar el Autor"/>
	</form:form>
</body>
</html>