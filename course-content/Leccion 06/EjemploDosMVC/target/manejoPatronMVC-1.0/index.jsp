<!DOCTYPE html>
<html>
    <head>
        <title>MVC</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo MVC Dos</h1>
        <br/>
        <div style="color: red">
            ${mensaje}
        </div>
        <br/>
        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/ServletControl" style="text-decoration: none;">
                    Link al Servlet Controlador sin parametros
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/ServletControl?accion=agregaVariables" style="text-decoration: none;">
                    Link al Servlet Controlador para agregar variables
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/ServletControl?accion=listarVariables" style="text-decoration: none;">
                    Link al Servlet Controlador para agregar variables
                </a>
            </li>
        </ul>
    </body>
</html>
