
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inclusion</title>
    </head>
    <body>
        <h1>Ejemplo Inclusion Estatica</h1>
        <br/>
        <ul>
            <li><%@include  file="paginas/noticias1.html"%></li>
            <li><%@include  file="paginas/noticias2.jsp"%></li>
        </ul>
        <br/>
        <br/>
        <h1>Ejemplo Inclusion Dinamica</h1>
        <jsp:include page="paginas/recursoPublico.jsp"/>
        <br/>
        <jsp:include page="WEB-INF/recursoPrivado.jsp">
            <jsp:param name="colorFondo" value="gold"/>
        </jsp:include>
    </body>
</html>
