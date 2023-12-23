
package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Rectangulo;

@WebServlet("/ServletControlador")
public class ServletControlador  extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        //1. Procesar paraetro
        
        //2. Creamos JavaBean
        
        Rectangulo rectangulo = new Rectangulo(2, 4);
        
        //3. Agregamos el JavaBean a algun alcanze
            //Saludo agregado al alcanze de request
        request.setAttribute("mensaje", "Saludos desde el Servlet");
            //JavaBean agregado al alcanze de Session
        HttpSession sesion = request.getSession();
        sesion.setAttribute("rectangulo", rectangulo);
        
        //4. Redireccionar a la vista seleccionada
        RequestDispatcher rqd = request.getRequestDispatcher("vista/desplegarVariable.jsp");
        rqd.forward(request, response);
        
    }
}
