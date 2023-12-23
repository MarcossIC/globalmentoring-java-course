
package nuevoCursoLevel2;


public class Persona2 {
    private String nombre;
    private double sueldo;
    private boolean eliminado;

    public Persona2(String nombre, double sueldo, boolean eliminado) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.eliminado = eliminado;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public String toString() {
        return "Persona2{" + "nombre: " + this.nombre + 
                             ", sueldo: " + this.sueldo + 
                             ", eliminado: " + this.eliminado + '}';
    }
    

}
