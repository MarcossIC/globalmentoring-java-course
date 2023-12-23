
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html; charset=UTF-8");
        //Simulando valores correctos
        String userOK = "Juan";
        String passwordOK = "123";
        
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        
        PrintWriter out = response.getWriter();
        if(!userOK.equals(user) || !passwordOK.equals(password)){
            response.sendError(response.SC_UNAUTHORIZED, "Credenciales Incorrectas");
        }
        if(userOK.equals(user) && passwordOK.equals(password)){
            out.print("<h1>");
            out.print("Datos correctos");
            out.print("<br/>");
            out.print("<p>Usuario: " +user+ "</p>");
            out.print("<p>password: " + password+ "</p>");
            out.print("</h1>");
        }
        
        
        out.close();  
    }
}
