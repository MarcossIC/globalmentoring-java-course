
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ContadorVisitasServlet")
public class ContadorVisitasServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Variable contador 
        int contador = 0;
        
        //Revisamos si existe
        
        Cookie[] cookies = request.getCookies();
        
        if(cookies != null){
            for (Cookie c : cookies) {
                if(c.getName().equals("contadorVisitas")){
                    contador = Integer.parseInt(c.getValue());
                }
            }
        }
        //Incrementar el contador en +1
        contador++;
        
        //Agrego la respuesta al nvegador
        
        Cookie nuevaCookie = new Cookie("contadorVisitas", Integer.toString(contador));
        
        //Se almacenara en el cliente por una hora
        nuevaCookie.setMaxAge(3600);
        
        response.addCookie(nuevaCookie);
        
        response.setContentType("text/html; charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        out.print("Contador de visitas de cada cliente: " + contador);
        
    }
}
