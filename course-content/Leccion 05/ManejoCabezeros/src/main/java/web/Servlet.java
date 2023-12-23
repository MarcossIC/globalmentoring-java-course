
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletHeader")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html; charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        String metodoHttp = request.getMethod();
        String uri = request.getRequestURI();
        Enumeration cabezeros = request.getHeaderNames();
        String pathInfo = request.getPathInfo();
        String remoterHost = request.getRemoteHost();
        String queryString = request.getQueryString();
        String scheme = request.getScheme();
        String sesionId = request.getRequestedSessionId();
        String serverName = request.getServerName();
        String authT = request.getAuthType();
        
        out.print("<html>");
        out.print("<head>");
        out.print("<title>HEADER HTTP</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Metodo http</h1>");
        //Cabezeros disponibles
        while(cabezeros.hasMoreElements()){
            String nombreCabezero = (String) cabezeros.nextElement();
            out.print("<p> <b>" + nombreCabezero + "</b>: "+request.getHeader(nombreCabezero)+"</p>");
        }
        out.print("</br>");
        out.print("<h2>Mis pruebas</h2>");
        out.print("<p><b>Metodo Http:</b> " + metodoHttp + " </p>");
        out.print("<p><b>La URI solicitada:</b> " + uri + " </p>");
        out.print("<p><b>Path Info:</b> " + pathInfo + " </p>");
        out.print("<p><b>Remoter Host:</b> " + remoterHost + " </p>");
        out.print("<p><b>Query:</b> " + queryString + " </p>");
        out.print("<p><b>Scheme:</b> " + scheme + " </p>");
        out.print("<p><b>Sesion ID:</b> " + sesionId + " </p>");
        out.print("<p><b>Server Name:</b> " + serverName + " </p>");
        out.print("<p><b>Auth Type:</b> " + authT + " </p>");
        
        out.print("</body>");
        out.print("</html>");
        
        out.close();
        
    }
}
