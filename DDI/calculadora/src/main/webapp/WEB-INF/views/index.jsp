<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <tittle> Calculadora </tittle>
    </head>
    <body>
        <form:form action="calcular" method="post" modelAttribute="resultado">
            <input type="number" value="numero1" name="numero1"/>
            <select name="operacion" value="operacion">
                <option value="suma">+</option>
                <option value="resta">-</option>
                <option value="multiplicacion">*</option>
                <option value="division">/</option>
            </select>
            <input type="number" value="numero2" name="numero2"/>
            <input type="submit" value="calcular"/>
        </form:form>
        <div>${calculo.getNumero1()} ${calculo.getOperacion()} ${calculo.getNumero2()} = ${resultado}</div>
    </body>
</html>
