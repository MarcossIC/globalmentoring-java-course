<%@page isErrorPage="true" %>
<%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Internal Error!</h1>
        <br/>
        <p>Ocurrio un Error: <%= exception.getMessage() %></p>
        <textarea cols="30" rows="5">
                <% exception.printStackTrace(new PrintWriter(out));  %>
        </textarea>
    </body>
</html>
