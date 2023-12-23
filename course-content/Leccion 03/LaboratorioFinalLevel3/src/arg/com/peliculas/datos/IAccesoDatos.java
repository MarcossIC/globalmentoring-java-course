 
package arg.com.peliculas.datos;

import arg.com.peliculas.domain.Pelicula;
import arg.com.peliculas.excepciones.*;
import java.util.List;

 
public interface IAccesoDatos {
    
    boolean existe(String nombreRecurso) throws AccesoDatosEX;
    
    List<Pelicula> listar(String nombreRecurso) throws LecturaEX;
    
    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraEX;
    
    String buscar(String nombreArchivo, String buscar) throws LecturaEX;
    
    void crear(String nombreArchivo) throws AccesoDatosEX;
    
    void borrar(String nombreArchivo) throws AccesoDatosEX;
}
