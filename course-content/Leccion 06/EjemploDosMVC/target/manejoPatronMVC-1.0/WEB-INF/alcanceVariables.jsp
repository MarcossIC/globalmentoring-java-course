
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance Variables</title>
    </head>
    <body>
        <h1>Alcance Variables</h1>
        <br/>
        <ul>
            <legend>Variable alcance request</legend>
            <li>Base:
                ${rectangleRequest.base}
            </li>
            <li>Altura:
                ${rectangleRequest.altura}
            </li>
            <li>Area:
                ${rectangleRequest.area}
            </li>
        </ul>
        <ul>
            <legend>Variable alcance Sesion</legend>
            <li>Base:
                ${rectangleSession.base}
            </li>
            <li>Altura:
                ${rectangleSession.altura}
            </li>
            <li>Area:
                ${rectangleSession.area}
            </li>
        </ul>
        <ul>
            <legend>Variable alcance Applicacion</legend>
            <li>Base:
                ${rectangleApplication.base}
            </li>
            <li>Altura:
                ${rectangleApplication.altura}
            </li>
            <li>Area:
                ${rectangleApplication.area}
            </li>
        </ul>
        <br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Inicio</a>
    </body>
</html>
