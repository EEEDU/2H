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
	<form action="searchByNameBook" method="get">7
		Titulo del libro: <input type="text" name ="name"/>
		<input type="submit" value="buscar"/>
	</form>
	
	<table class="table">
		  <thead>
		    <tr>
		      <th>Titulo</th>
			  <th>Isbn</th>
			  <th>autor</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${listBooks}" var="book">
				<tr>
					<td><c:out value="${book.title}" /></td>
					<td><c:out value="${book.isbn}" /></td>
					<td><c:out value="${book.authorName}" /></td>
				</tr>
			</c:forEach>
		  </tbody>
		</table>
</body>
</html>