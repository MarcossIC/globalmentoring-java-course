
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Despliegue de Variables</title>
    </head>
    <body>
        <h1>Despliegue de Variables</h1>
        <p>Variable en alcance request: 
            ${mensaje}
        </p>
        <ul>
            <li>Base: ${rectangulo.base}</li>
            <li>Altura ${rectangulo.altura}</li>
            <li>Area: ${rectangulo.area}</li>
        </ul>
        <br/>
        <a href="${pageContext.request.contextPath}">Inicio</a>
    </body>
</html>
