package test;

import java.util.*;

public class TestColecciones {

    public static void main(String[] args) {
        List miLista = new ArrayList();

        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");

        //  imprimir(miLista);
        /*
        miLista.forEach(elemento -> {
        System.out.println("elementos: " + elemento);
        });
         */
        //  System.out.println("\n");
        Set miSet = new HashSet();

        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");

        // imprimir(miSet);
        Map miMapa = new HashMap();

        miMapa.put("Saludo", "Hola");
        miMapa.put("Nombre", "Juan");

        String elemento = (String) miMapa.get("Saludo");

        System.out.println("elemento = " + elemento);

        imprimir(miMapa.keySet());
        System.out.println();
        imprimir(miMapa.values());
        System.out.println();
        imprimir(miMapa.entrySet());
    }

    public static void imprimir(Collection coleccion) {
        coleccion.forEach(elemento -> {
            System.out.println("elemento = " + elemento);
        });
    }
}
