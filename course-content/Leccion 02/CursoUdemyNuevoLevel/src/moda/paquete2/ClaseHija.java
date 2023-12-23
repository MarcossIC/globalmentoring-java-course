package moda.paquete2;

import moda.paquete1.Clase1;



public class ClaseHija extends Clase1{
    

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ClaseHija() { 
        super("h", "h2");
        this.atributoProtected = "Modificacion atributo protegido";
        System.out.println("atributo protegido: "+ this.atributoProtected);
        this.metodoProtected();
        
    }
}
