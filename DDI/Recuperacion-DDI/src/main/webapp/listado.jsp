<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.io.*,java.util.*,es.salesianos.entities.*" %>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="cargarListado" method="post">
	<input type="submit" value="ver listado">
</form>

<% 
 List<Alumno> alumnos = (List<Alumno>)request.getAttribute("listAllUsers");
 out.println(alumnos);
 pageContext.setAttribute("alumnos", alumnos);
%>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>

<table border="1">
	<thead>
		<tr>
			<td>Nombre</td>
			<td>Curso</td>
			<td>Voto</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="alumno1" items="${listAllUsers}">
			<tr>
				<td><c:out value="${alumno1.nombre"/> </td>
				<td><c:out value="${alumno1.clase}"/> </td>
				<td><a href="/edit?id=${alumno1.voto}">EDITAR</a> </td>
				
	    	</tr>
		</c:forEach>
	</tbody>
</table>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>


<table border="1">
<thead>
	<tr>
		<td>Nombre</td>
		<td>Fecha</td>
		<td>Curso</td>
	</tr>
</thead>
<tbody>
<%

if(null != alumnos && !alumnos.isEmpty()){
	for (Alumno alumno2 : alumnos) {
		out.println("<tr>");
		out.println("<td>");
		out.println(alumno2.getNombre());
		out.println("</td>");
		out.println("<td>");
		out.println(alumno2.getVoto());
		out.println("</td>");
		out.println("</tr>");
	}
		
}
%>
</tbody>
</table>







</body>
</html>