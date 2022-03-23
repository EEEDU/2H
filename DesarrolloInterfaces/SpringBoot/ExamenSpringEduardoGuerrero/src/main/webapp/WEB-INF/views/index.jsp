<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <tittle> Calculadora </tittle>
    </head>
    <body>
        <form:form action="jugar" method="post" modelAttribute="carton">
            <input type="submit" value="jugar"/>
        </form:form>
        <form:form action="bola" method="post" modelAttribute="bola">
            <input type="submit" value="bola"/>
        </form:form>
        <div> ${carton[0][0]} - ${carton[0][1]} - ${carton[0][2]} - ${carton[0][3]} - ${carton[0][4]}</div>
        <div> ${carton[1][0]} - ${carton[1][1]} - ${carton[1][2]} - ${carton[1][3]} - ${carton[1][4]}</div>
        <div> ${carton[2][0]} - ${carton[2][1]} - ${carton[2][2]} - ${carton[2][3]} - ${carton[2][4]}</div>
        <br/>
        <div>${bola}</div>
        <div>${fin}</div>
        <div>Tienes ${lineas} lineas</div>
    </body>
</html>