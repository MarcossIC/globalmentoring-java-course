package arg.com.peliculas.datos;

import arg.com.peliculas.domain.Pelicula;
import arg.com.peliculas.excepciones.AccesoDatosEX;
import arg.com.peliculas.excepciones.EscrituraEX;
import arg.com.peliculas.excepciones.LecturaEX;
import java.io.*;
import java.util.*;

public class AccesoDatosImpl implements IAccesoDatos {

    public AccesoDatosImpl() {

    }

    @Override
    public boolean existe(String nombreRecurso) {
        File archivo = new File(nombreRecurso);

        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaEX {
        var archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();

        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;

            linea = entrada.readLine();
            while (linea != null) {
                var pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                
                linea = entrada.readLine();
            }
            entrada.close();   
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaEX("Excepcion al listar peliculas: " + ex.getMessage());

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaEX("Excepcion al listar peliculas: " + ex.getMessage());
        }

        return peliculas;
        
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraEX {
        var archivo = new File(nombreRecurso);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraEX("Excepcion al escribir en el archivo: " + ex.getMessage());
        }

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaEX {
        var archivo = new File(nombreArchivo);
        String resultado = null;

        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();

            var indice = 1;
            while (lectura != null) {
                if (buscar != null && buscar.equalsIgnoreCase(lectura)) {
                    resultado = "Pelicula: " + lectura + ", encontrada en el indice: " + indice;
                    break;
                }
                lectura = entrada.readLine();
                indice++;
            }
            entrada.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaEX("Excepcion al escribir en el archivo: " + ex.getMessage());

        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaEX("Excepcion al escribir en el archivo: " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEX {
        var archivo = new File(nombreArchivo);
        try {
                PrintWriter salida = new PrintWriter(archivo);
                salida.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEX("Excepcion al escribir en el archivo: " + ex.getMessage());
        }

    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEX  {
        var archivo = new File(nombreArchivo);
        
        if(this.existe(nombreArchivo))
            archivo.delete(); 
    }

}
