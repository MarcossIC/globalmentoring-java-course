
package bloquesinicializacion.domian;


public class Persona {
    private final int idPersona;
    private static int contadorPersona;
    
    static{
        System.out.println("Ejecucion Bloque estatico");
        ++Persona.contadorPersona;
    }
    
    {
        System.out.println("Ejecucion bloque no estatico");
        this.idPersona = Persona.contadorPersona++;
    }
    
    public Persona(){
        System.out.println("Ejecucion dle constructor");
    }

    public int getIdPersona() {
        return idPersona;
    }
 
}
