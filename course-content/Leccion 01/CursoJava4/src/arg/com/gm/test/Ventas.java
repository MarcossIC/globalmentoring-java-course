
package arg.com.gm.test;

import arg.com.gm.ventas.Orden;
import arg.com.gm.ventas.Producto;


public class Ventas {
    public static void main(String[] args) {
        Orden orden1 = new Orden();
        
        orden1.agregarProducto(new Producto("Manzana", 100));
        orden1.agregarProducto(new Producto("Naraja", 50));
        orden1.agregarProducto(new Producto("Pera", 250));
        orden1.agregarProducto(new Producto("Mandarina", 75));
        orden1.agregarProducto(new Producto("Quinoto", 25.25));
        orden1.agregarProducto(new Producto("Frutilla", 18.39));
        orden1.agregarProducto(new Producto("Sandia", 129.99));
        orden1.agregarProducto(new Producto("CucaMelon", 42));
        orden1.agregarProducto(new Producto("Pomelo", 58));
        orden1.agregarProducto(new Producto("Romero", 77));
        
        orden1.mostrarOrden();
   
    }
}
