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
	<form action="searchByName" method="get">
		Buscar por nombre:<input type="text" name="name" />
		<input type="submit" value="buscar"/>
	</form>
	<table>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>fecha de nacimiento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${authors}" var="author">
				<tr>
					<td><c:out value="${author.name}" /></td>
					<td><c:out value="${author.dateOfBirth}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>