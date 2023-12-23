
package proyectoLevel1;

public class Inicio {
    public static void main(String[] args) {
        Caja caja1 = new Caja(3, 2, 6);
        Caja caja2 = new Caja();
        
        caja2.alto = 5;
        caja2.ancho = 7;
        caja2.profundo = 4;
        
       var result = caja2.calcularVolumen();
       
        System.out.println("El volumen de la caja es: " + result); 
        System.out.println();
        result = caja1.calcularVolumen();
        
        System.out.println("El volumen de la caja es:  " + result);
        
        
        
    }
}
