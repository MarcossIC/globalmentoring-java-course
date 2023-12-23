package nuevoCursoRepasando;

public class Repaso6 {

    public static void main(String[] args) {

        //En este caso cuando el for "Lea" el continue, esa repeticion termina e sube al for 
        //para incrementar i y volver a empezar
        System.out.println("Continue");
        for (var i = 0; i < 3; i++) {
            if (i % 2 != 0) {
                continue;
            } else {
                System.out.println("contador = " + i);
                
            }
        }

        //En este caso cuando el for "Lea" el Break el bucle entero termina 
        //Osea termina el for ignorando las siguiente repeticiones y sale del for
        System.out.println("Breack");
        for (var i = 0; i < 3; i++) { 
            if (i % 2 == 0) {
                System.out.println("contador = " + i);
                break;
            }
        }
        
    }
}
