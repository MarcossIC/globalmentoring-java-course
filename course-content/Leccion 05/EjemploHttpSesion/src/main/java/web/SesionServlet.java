
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SesionServlet")
public class SesionServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html; charset=UTF-8");
        
        HttpSession sesion = request.getSession();
        String titulo = null;
        
        //Contador Visitas
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        
        //Si es nulo es la primera vez que accedes a la aplicacion
        if(contadorVisitas != null){
            contadorVisitas++;
            titulo = "Bienvenido nuevamente";
        }
        if(contadorVisitas == null){
            contadorVisitas = 1;
            titulo= "Bienvenido por primera vez";
        }
        //Agregamos el nuevo valor a la Sesion
        sesion.setAttribute("contadorVisitas", contadorVisitas);
        
        //Respuesta al cliente
        PrintWriter out = response.getWriter();
        
        out.print(titulo);
        out.print("<br/>");
        out.print("Numero de accesos al recurso: "+ contadorVisitas);
        out.print("<br/>");
        out.print("ID de la sesion: "+ sesion.getId());
        
        out.close();
    }
}
