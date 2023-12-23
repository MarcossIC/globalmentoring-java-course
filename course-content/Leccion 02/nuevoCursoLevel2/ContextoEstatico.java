package nuevoCursoLevel2;

public class ContextoEstatico {
    
    private int contador;
    
    public static void main(String[] args) {
        Persona3 persona1 = new Persona3("Juan");
        Persona3 persona2= new Persona3("RAMIRO");
        
        imprimir(persona1);
        imprimir(persona2);
        
        
    }
    
    public static void imprimir(Persona3 persona){
        System.out.println("persona: " + persona);
        
    }
    
    public int getContador(){
        imprimir(new Persona3("Calros"));
        return this.contador;
    }
}

class Persona3 {

    private int idPersona;
    private String nombre;
    private static int contadorPersonas;

    public Persona3(String nombre) {
        this.nombre = nombre;

        Persona3.contadorPersonas++;

        this.idPersona = Persona3.contadorPersonas++;
    }

    @Override
    public String toString() {
        return "Persona3{ " + "idPersona: " + idPersona + ", nombre: " + nombre + " }";
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static void setContadorPersonas(int contadorPersonas) {
        Persona3.contadorPersonas = contadorPersonas;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public static int getContadorPersonas() {
        return contadorPersonas;
    }

}
