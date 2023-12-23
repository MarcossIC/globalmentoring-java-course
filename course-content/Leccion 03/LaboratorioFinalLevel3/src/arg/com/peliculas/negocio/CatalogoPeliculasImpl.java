package arg.com.peliculas.negocio;

import arg.com.peliculas.datos.*;
import arg.com.peliculas.domain.Pelicula;
import arg.com.peliculas.excepciones.*;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

    private final IAccesoDatos datos;
    private String mensaje;
    private String mensaje2;

    public CatalogoPeliculasImpl() {
        mensaje = "";
        mensaje2 = "";
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        boolean anexar = false;

        try {
            anexar = this.datos.existe(NOMBRE_RECURSO);
            this.datos.escribir(new Pelicula(nombrePelicula), NOMBRE_RECURSO, anexar);    
        } catch (AccesoDatosEX ex) {
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (Pelicula p : peliculas) {
                if (p != null) {
                    mensaje += "Pelicula: " + p.toString() + "\n";
                } else {
                    mensaje = "No hay pelicula en el catalogo";
                }
            }
            mensaje2 = "Se ha listado la informacion";
        } catch (LecturaEX ex) {
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void buscarPelicula(String buscar) {

        try {
            if (buscar.equalsIgnoreCase(" ") == false && buscar != null) {
                mensaje = this.datos.buscar(NOMBRE_RECURSO, buscar);
            } else {
                mensaje = "No se ha encontrado";
            }
        } catch (AccesoDatosEX ex) {
            mensaje = "Error de acceso a datos";
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (datos.existe(NOMBRE_RECURSO)) {

                this.datos.borrar(NOMBRE_RECURSO);
                this.datos.crear(NOMBRE_RECURSO);

            } else {
                this.datos.crear(NOMBRE_RECURSO);

            }
        } catch (AccesoDatosEX ex) {    
            ex.printStackTrace(System.out);
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getMensaje2() {
        return mensaje2;
    }
    
    

}
