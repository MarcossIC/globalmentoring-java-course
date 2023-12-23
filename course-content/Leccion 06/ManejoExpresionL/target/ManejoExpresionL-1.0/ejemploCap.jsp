
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo de Expression Language</title>
    </head>
    <body>
        <h1>Ejemplo de Expression Language</h1>
        <br/>
        <h2>Variables Implicitas</h2>
        <ul>
            <li>Nombre de la aplicacion: ${pageContext.request.contextPath}</li>
            <li>Navegador del cliente: ${header["user-agent"]}</li>
            <li>ID Session: ${cookie.JSESSIONID.value}</li>
            <li>Web Servlet: ${pageContext.servletContext.serverInfo}</li>
            <li>Valor Paramtero: ${param["usuario"]}</li>
        </ul>
        <br/>
        <a href="index.html">Inicio</a>
    </body>
</html>
