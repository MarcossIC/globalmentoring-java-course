
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CokiesServlet")
public class CokiesServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Suponemos que el usuario visita nuestro sitio por primera vez
        boolean nuevoUsuario = true;
        
        //Obtenemos el arreglo de cokies
        Cookie[] cookies = request.getCookies();
        
        //Buscamo si ya existe una cokie creada antes
        //Visitante recurrente
        if(cookies != null){
            for (Cookie c : cookies) {
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")){
                    //Si ya existe la cookie significa que es usuario recurrente
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        String msg= null;
        if(!nuevoUsuario){
            msg = "Gracias por visitar nuevamente nuestro sitio";
        }
        if(nuevoUsuario){
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
            response.addCookie(visitanteCookie);
            msg = "Gracias por visitra nuestor sitio por primera vez";
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Respuesta HTML</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<p>");
        out.print("Mensaje = " + msg);
        out.print("</p>");
        out.print("</body>");
        out.print("</html>");
        
        out.close();
    }
}
