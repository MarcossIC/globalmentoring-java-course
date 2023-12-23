
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP con ScriptLets</title>
    </head>
    <body>
        <h1>JSP con ScriptLets</h1>
        <br/>
        <%-- ScriptLets para enviar informacion al navegador --%>
        <% 
            out.print("Saludos desde un ScriptLets");
        %>
        <%-- ScriptLets para manipular los objetos implicados --%>
        <%
          String  nombreAplicacion = request.getContextPath();
          out.print("Nombre de la Aplicacion: " + nombreAplicacion);
        %>
        <%-- ScriptLets con codigo condicionado --%>
        <% 
            if(session != null && session.isNew()){
        %>
        <p>La sesion SI es nueva</p>
        <%
            }else if(session != null){
        %>
        <p>La sesion NO es nueva</p>
        <% } %>
        <br/>
        <a href="index.html">Inicio</a>
    </body>
</html>
