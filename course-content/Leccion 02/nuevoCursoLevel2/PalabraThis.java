
package nuevoCursoLevel2;


public class PalabraThis {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", "Perez");
        
        System.out.println();
        System.out.println("persona = " + persona);
        System.out.println("persona nombre: " + persona.nombre);
        System.out.println("persona nombre: " + persona.apelido);
    }
}

class Persona{
    
    String nombre;
    String apelido;

    Persona(String nombre, String apelido) {
        this.nombre = nombre;
        this.apelido = apelido;
        System.out.println("objeto persona: " + this);
        System.out.println();
        new Imprimir().Imprimir(this);
    }
}

class Imprimir{
    
    public void Imprimir(Persona persona){
        System.out.println("Persona desde Imprimir: "+ persona);
        System.out.println("Impresion del objeto actual(this): " + this);
    }
}
