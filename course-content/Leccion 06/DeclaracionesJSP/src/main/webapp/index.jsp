<%-- Agregamos una declaracion de JSP --%>
<%! 
        //Declaramos una Variable con su metodo Get
    private String user = "Alberto";

    public String getUser(){
        return this.user;
    }
        //Contador visitas
    private int contadorVisitas = 1;
   
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practica JSP</title>
    </head>
    <body>
        <h1>Uso de Declaraciones con JSP</h1>
        
        <p>Valor de Usuario por medio del atributo: </p><%= this.user%>
        <p>Valor de Usuario por medio del metodo: </p><%= this.getUser()%>
        <p>Contador Visitas: </p> <%= this.contadorVisitas++%>
    </body>
</html>
