
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/HolaServlet")
public class HolaServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html; charset=UTF-8");
        
        response.setHeader("refresh", "1");
        Date fecha = new Date();
        SimpleDateFormat formatD = new SimpleDateFormat("'Hora Actualizada' HH:mm:ss");
        String horaFormateada = formatD.format(fecha);
        
        PrintWriter out = response.getWriter();
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Formato de Hora</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("Hora Actualizada: " + horaFormateada);
        out.print("</body>");
        out.print("</html>");
 
    }
}
