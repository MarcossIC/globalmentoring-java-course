
package nuevoCursoRepasando;

import java.util.Scanner;


public class Repaso2 {
    public static void main(String[] args) {
        var nombre = "Karla";
        
        System.out.println("Nueva Linea: \n" + nombre);
        System.out.println("Tabulador: \t" + nombre);
        System.out.println("Retroceso:    \b" + nombre);
        System.out.println("Comilla simple: \'" + nombre + "\'");
        System.out.println("Comilla doble: \"" + nombre + "\"");
        
        System.out.println();
        System.out.println();
        
        System.out.println("Escribe tu nombre: ");
        Scanner scn = new Scanner(System.in);
        var usuario = scn.nextLine();
        
        System.out.println("nombre: " + usuario);
    }
}
