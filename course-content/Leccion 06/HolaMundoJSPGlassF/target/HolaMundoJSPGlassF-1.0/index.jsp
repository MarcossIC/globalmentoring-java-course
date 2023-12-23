<%-- 
    Document   : index
    Created on : 26 nov 2021, 10:10:23
    Author     : Marcos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>HolaMundo JSPs</title>
    </head>
    <body>
        <h1>Ejemplos de JSPs</h1>
        <ul>
            <li><% out.print("HolaMundo con Sriplets"); %></li>
            <li>${"HolaMundo con Expresiones Language (EL)"}</li>
            <li><%= "Hola Mundo con Expresiones"%></li>
            <li> <c:out value="HolaMundo con JSTL (JavaServer Page Standard Tag Library)" /></li>
        </ul>
    </body>
</html>