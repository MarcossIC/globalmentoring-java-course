package test;

import ejem.enumeracion.Continentes;
import ejem.enumeracion.Dias;

public class TestEnumeraciones {

    public static void main(String[] args) {
        System.out.println(Dias.DOMINGO);
        
        indicarDiasDeLaSemana(Dias.LUNES);
        
        System.out.println("");
        
        System.out.println("Continente N. 4 " + Continentes.AMERICA);
        System.out.println("No. Paises en el continente No.4: " + Continentes.AMERICA.getPaises());
        
        System.out.println("Continente N. 1 " + Continentes.AFRICA);
        System.out.println("No. Paises en el continente No.4: " + Continentes.AFRICA.getPaises());
    }

    private static void indicarDiasDeLaSemana(Dias dias) {
        switch (dias) {
            case LUNES ->
                System.out.println("Es el primer dia de la semana");
            case MARTES ->
                System.out.println("Es segundo dia de la semana");
            case MIERCOLES ->
                System.out.println("Es el tercer dia de la semana");
            case JUEVES ->
                System.out.println("");
            case VIERNES ->
                System.out.println("");
            case SABADO ->
                System.out.println("");
            case DOMINGO ->
                System.out.println("");
        }
    }
}
