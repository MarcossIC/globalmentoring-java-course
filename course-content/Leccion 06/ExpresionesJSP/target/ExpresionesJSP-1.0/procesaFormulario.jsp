
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Procesa Formulario</title>
    </head>
    <body>
        <h1>Resultado del Formulario</h1>
        <p>Usuario: <%= request.getParameter("user") %></p> 
        <br/>
        <p>PassWord: <%= request.getParameter("password") %></p> 
        <br/>
        <a href="/ExpresionesJSP">Volver al Inicio</a>
    </body>
</html>
