

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lee valores de JavaBean</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="request"/>
        <p>Valor base: <jsp:getProperty name="rectangulo" property="base"/></p>
        <p>Valor altura: <jsp:getProperty name="rectangulo" property="altura"/></p>
        <p>Valor del Area: <jsp:getProperty name="rectangulo" property="area"/></p>
        <br/>
        <a href="index.jsp">Inicio</a>
    </body>
</html>
