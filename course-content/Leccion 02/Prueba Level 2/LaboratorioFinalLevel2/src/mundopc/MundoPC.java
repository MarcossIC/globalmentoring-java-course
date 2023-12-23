package mundopc;

import com.ml.mundopc.Computadora;
import com.ml.mundopc.Monitor;
import com.ml.mundopc.Orden;
import com.ml.mundopc.Raton;
import com.ml.mundopc.Teclado;

public class MundoPC {

    public static void main(String[] args) {
        
        Orden orden = new Orden();
        

        Monitor monitor = new Monitor("Asus", 150.5);
        Teclado teclado = new Teclado("Ryzen", "Bluetooth");
        Raton raton = new Raton("Ryzen", "USB");

        Monitor monitor2 = new Monitor("Back", 135.5);
        Teclado teclado2 = new Teclado("Ryzen", "Bluetooth");
        Raton raton2 = new Raton("Ryzen", "USB");

        orden.agregarComputadora(new Computadora("Asus", monitor, teclado, raton));
        orden.agregarComputadora(new Computadora("Intel", monitor2, teclado2, raton2));
        orden.agregarComputadora(new Computadora("Rayzen", monitor, teclado2, raton));
       
        orden.mostrarOrden();

    }
}
