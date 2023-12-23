

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expression Language</title>
    </head>
    <body>
        <h1>Manejo Expression Language</h1>
        <br/>
        <p>Session ID: ${pageContext.session.id}</p>
        <p>Parametro: ${header["view"]}</p>
        <p>Suma: ${3+3}</p>
        <p>Valor de la clase: ${header["ClassValue"]}</p>
        <p>Page: ${pageContext.page}</p>
        <p>Prueba: ${pageScope.request}</p>
        <br/>
        <a href="index.html">Inicio</a>
    </body>
</html>
