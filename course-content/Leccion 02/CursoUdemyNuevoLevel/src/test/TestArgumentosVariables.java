
package test;


public class TestArgumentosVariables {
    public static void main(String[] args) {
        imprimirNumeros(3, 4 ,5);
        imprimirNumeros(1, 2);
        imprimirNumeros(1, 5, 6, 7, 8, 9, 10, 11, 12);
    }
    
    private static void variosParametros(String nombre, int... numeros){
        System.out.println("nombre: " + nombre);
        imprimirNumeros(numeros);
    }
    
    private static void imprimirNumeros(int... numeros){
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("elemento: " + numeros[i]);
        }
        System.out.println("");
    }
}
