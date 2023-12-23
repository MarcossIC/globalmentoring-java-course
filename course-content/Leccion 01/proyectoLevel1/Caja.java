
package proyectoLevel1;


public class Caja {
     int ancho;
     int alto;
     int profundo;
    
    public Caja(){
        System.out.println("Se esta ejecutando constructor");
    }

    public Caja(int ancho, int alto, int profundo) {
        this.ancho = ancho;
        this.alto = alto;
        this.profundo = profundo;
    }
    
    public int calcularVolumen(){
        
        return ancho * alto * profundo;
    }
    
    
    
}
