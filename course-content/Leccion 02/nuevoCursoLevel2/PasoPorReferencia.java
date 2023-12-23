
package nuevoCursoLevel2;

import nuevoCursoRepasando.Persona;


public class PasoPorReferencia {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        persona1.nombre = "Marcos";
        
        //Con void
        System.out.println("persona1 nombre: " + persona1.nombre);
        cambiaValor(persona1);  
        System.out.println("persona1 nombre: " + persona1.nombre);
        
        System.out.println();
        
        //Con return
        persona1 = cambiaValor2(persona1);
        
        System.out.println("persona1 nombre: " + persona1.nombre);
    }
    
    public static void cambiaValor(Persona persona){
        persona.nombre = "karla";
    }
    
    public static Persona cambiaValor2(Persona persona){
        persona.nombre = "karla";
        return persona;
    }
}
