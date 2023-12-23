package test;

import domain.Empleado;

public class TestClaseobject {

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("juan", 5000);
        Empleado empleado2 = new Empleado("Juan", 5000);

        //Comparando referencia en memoria
        if (empleado1 == empleado2) {
            System.out.println("Tienen la misma referencia en memoria");
        } else {
            System.out.println("Distinta referencia en memoria");
        }
        
        //Comparando contenidos
        if(empleado1.equals(empleado2)){
            System.out.println("Los objetos son iguales en contenido");
        } else {
            System.out.println("Los objetos son distintos en contenido");
        }
        
        //Comparando con valor entero
        if(empleado1.hashCode() == empleado2.hashCode()){
            System.out.println("El valor de hash code es  verdadero");
        } else {
            System.out.println("El valor de hash code es distinto");
        }
        
    }
}
