
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html; charset=UTF-8");
        HttpSession sesion = request.getSession();

        List<String> articulos = (List<String>) sesion.getAttribute("articulos");
        if(articulos == null){
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }
        
        String articuloNuevo = request.getParameter("articulo");
        
        if(articuloNuevo != null && !articuloNuevo.trim().equals("")){
            articulos.add(articuloNuevo);
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.print("<html>");
            out.print("<head>");
            out.print("<title>Lista Articulos</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<h1>Lista de Articulos</h1>");
            out.print("<br/>");
            for (String articulo : articulos) {
                out.print("<li>"+articulo+"</li>");
            }
            out.print("<br/>");
            out.print("<a href='/carritoCompras'>Regresar al Inicio</a>");
            out.print("</body>");
            out.print("</html>");
        }
    }
}
