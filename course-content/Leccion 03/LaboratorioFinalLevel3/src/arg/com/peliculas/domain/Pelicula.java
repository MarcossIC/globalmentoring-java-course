 
package arg.com.peliculas.domain;

 
public class Pelicula {
    private String nombrePelicula;
    private int año;
    private int duracion;
    
    
    public Pelicula(){
       
    }
    
    public Pelicula(String nombrePelicula){
        this.nombrePelicula = nombrePelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    @Override
    public String toString() {
        return nombrePelicula;
    }
    
    
}
