
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Core</title>
    </head>
    <body>
        <h1>JSTL Core (JSP Standard Tag Library)</h1>
        <!-- Manipulacion de Variables -->
        
        <!-- Defino la variable -->
        <c:set var="nombre" value="Ernesto"/>
        
        <!-- Muestro la variable -->
        <p>Variable nombre: <c:out value="${nombre}" /></p>
        <br/>
        
        <!-- Variable codigo HTML -->
        <c:out value="<h4>Hola</h4>" escapeXml="default"/> 
        <br/>
        <br/>
        <!-- Codigo condicionado if -->
        <c:set var="flag" value="true"/>
            
        <c:if test="${flag}">
            <p>La bandera es verdadera</p>
        </c:if>
        <br/>
        <!-- Codigo condicionado Switch -->
        <c:if test="${param.opcion != null}">
            <c:choose>
                <c:when test="${param.opcion == 1}">
                    <p>Opcion 1 seleccionada</p>
                </c:when>
                <c:when test="${param.opcion == 2}">
                    <p>Opcion 2 seleccionada</p>
                </c:when>
                <c:otherwise>
                    <p>Opcion desconocida</p>
                </c:otherwise>
            </c:choose>
        </c:if>
        <!-- Codigo de iteracion de arreglo -->
        <%
            String nombres[] = {"Marcos", "Luis", "Juan"};
            request.setAttribute("nombres", nombres);
        %>
        <br/>
        <ul>
            <c:forEach var="persona" items="${nombres}">
                <li>${persona}</li>
            </c:forEach>
        </ul>
        <br/>
        <a href="Index.jsp">Inicio</a>
    </body>
</html>
