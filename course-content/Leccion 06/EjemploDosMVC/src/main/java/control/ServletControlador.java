
package control;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Rectangulo;

@WebServlet("/ServletControl")
public class ServletControlador  extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        //1. Procesar paraetro
        String accion = request.getParameter("accion");
        
        //2. Creamos JavaBean
        
        Rectangulo rectangleRequest = new Rectangulo(2, 2);
        Rectangulo rectangleSession = new Rectangulo(3, 4);
        Rectangulo rectangleApplication = new Rectangulo(5, 6);
        
        //3. Agregamos el JavaBean a algun alcanze
        
        
            //Revisamos la accion
            if("agregaVariables".equals(accion)){
                //Alcance de request
                request.setAttribute("rectangleRequest", rectangleRequest);
                //Alcance de sesion
                HttpSession session = request.getSession();
                session.setAttribute("rectangleSession", rectangleSession);
                //Alcance de applicacion
                ServletContext application = this.getServletContext();
                application.setAttribute("rectangleApplication", rectangleApplication);
                
                //Mensaje
                request.setAttribute("mensaje", "Variables fueron agregadas");
                
                //4. Redireccionamos JSP a Index
                
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            if("listarVariables".equals(accion)){
                //4. Redireccionamos al JSP que despliega las variables
                request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
            } else {
                                //4. Redireccion si el parametro es nulo
                request.setAttribute("mensaje", "Accion desconocida");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                /*
                    response.sendRedirect("index.jsp");
                   Este metodo tambien redirige al index.jsp. Pero con esta linea no agregarias
                    informacion al JSP es decir no puedes propagar el objeot request y response
                    para pasarle informacion. Es una forma de redirigir el flujo
                */
            }
            
            
    }
}
