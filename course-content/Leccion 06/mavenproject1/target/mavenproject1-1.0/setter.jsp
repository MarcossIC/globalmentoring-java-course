
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar</title>
    </head>
    <body>
        <h1>Modifica JavaBean de Rectangulo</h1>
        <jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="request"/>
        <p>Modificamos los atributos</p>
        <%
            int baseValor = 5;
            int alturaValor = 10;
        %>
        <jsp:setProperty name="rectangulo" property="base" value="<%=baseValor%>"/>
        <jsp:setProperty name="rectangulo" property="altura" value="<%=alturaValor%>"/>
        <br/>
        <p>Nuevo valor base: <%=baseValor%></p>
        <p>Nuevo valor altura: <%=alturaValor%></p>
        <br/>
        
        <a href="index.jsp">Inicio</a>
    </body>
</html>
