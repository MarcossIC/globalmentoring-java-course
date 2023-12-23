
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP con Expresiones</title>
    </head>
    <body>
        <h1>JSP con Expresiones</h1>
        <p>Concatenacion: <%= "Saludo" + " " + " JSP"%></p> 
        <p>Operacion Matematica <%= 2 * 3 / 2%></p> 
        <p>Sesion ID: <%= session.getId() %></p> 
        <br/><br/>
        <a href="/ExpresionesJSP">Volver a Inicio</a>
    </body>
</html>
