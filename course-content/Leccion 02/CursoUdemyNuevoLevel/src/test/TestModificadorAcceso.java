
package test;

import moda.paquete1.Clase1;
import moda.paquete2.Clase4;
import moda.paquete2.ClaseHija;


public class TestModificadorAcceso {
    public static void main(String[] args) {
        
        
        Clase1 clase = new Clase1("Publico");
        
        System.out.println("clase = " + clase.atributoP);
        clase.metodoPublico();
        System.out.println("\n");
        
        ClaseHija claseH = new ClaseHija();
        System.out.println("");
        
        Clase4 claseP = new Clase4("h1");
        
       
       
    }
}
