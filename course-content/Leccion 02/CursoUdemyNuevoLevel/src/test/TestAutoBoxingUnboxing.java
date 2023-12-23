package test;

public class TestAutoBoxingUnboxing {

    public static void main(String[] args) {
    //Clases Envolventes de tipos primitivos
        /*
    int - Integer
    long - Long
    float - Float
    double - Double
         */

        Integer entero = 10;  // AutoBoxing
        
        System.out.println("entero = " + entero);
        System.out.println("entero = " + entero.doubleValue());
        
        int entero2 = entero;  // UnBoxing
        
        System.out.println("entero2 = " + entero2);
    }

}
