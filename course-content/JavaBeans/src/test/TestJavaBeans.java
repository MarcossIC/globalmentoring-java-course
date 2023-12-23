
package test;

import domain.Persona;


public class TestJavaBeans {
    public static void main(String[] args) {
        Persona persona = new Persona();
        
        persona.setNombre("Benito");
        persona.setApellido("Camelo");
        
        System.out.println("nombre = " +persona.getNombre());
        System.out.println("apellido= " +persona.getApellido());
    }
 
}
