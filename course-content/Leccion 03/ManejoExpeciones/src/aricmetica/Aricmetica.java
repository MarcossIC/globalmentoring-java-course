
package aricmetica;

import exepcion.OperacionExepcion;


public class Aricmetica {
    
    public static int division(int numerador, int denominador){
        
        if(denominador == 0){
            throw new OperacionExepcion("Division entre 0");
        }
        
        return numerador / denominador;
        
    }
}
