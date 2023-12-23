package test;

import java.util.*;


public class TestColecciones {

    public static void main(String[] args) {
        
        //A diferencia de Map este si mantiene un orden
        //Es mas facil buscar un elemento pero es un poco mas lento por esto
        List<String> miLista = new ArrayList<>();

        //En este caso podes duplicar sin problemas
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Viernes");

        String elemento1 = miLista.get(0);

//        System.out.println("elemento1: " + elemento1);
//        imprimir(miLista);

        //  System.out.println("\n");
        
        //Ventajas del Set es mas rapido ya que este no mantiene un orden
        Set<String> miSet = new HashSet<>();

        //En este caso si duplicas se borra el duplicado quedandose con el original
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");
        miSet.add("Viernes");

//        imprimir(miSet);

        Map<String, String> miMapa = new HashMap<>();

        //En este caso si duplicas una llave se sustille el valor del original por el del duplicado
        miMapa.put("Saludo", "Hola");
        miMapa.put("Nombre", "Juan");
        miMapa.put("Nombre", "Julian");
        

        String elementoMapa = miMapa.get("Saludo");
//        System.out.println("elemento = " + elementoMapa);

        imprimir(miMapa.keySet());
        System.out.println();
        imprimir(miMapa.values());
       
        
    }

    public static void imprimir(Collection<String> coleccion) {
        coleccion.forEach(elemento -> {
            System.out.println("elemento = " + elemento);
        });
    }
}
