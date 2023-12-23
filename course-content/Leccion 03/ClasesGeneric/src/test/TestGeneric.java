
package test;

import generico.ClaseGenerica;


public class TestGeneric {
    public static void main(String[] args) {
        ClaseGenerica<Integer> objetoInt = new ClaseGenerica<>(15);
        
        objetoInt.obtenerTipo();
        
        ClaseGenerica<String> objetoString = new ClaseGenerica<>("Juan");
        
        objetoString.obtenerTipo();
    }
}
