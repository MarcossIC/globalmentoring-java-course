package nuevoCursoRepasando;

public class Repaso5 {

    public static void main(String[] args) {
        int a = 3, b = 2;

        if (b % 2 == 0) 
            System.out.println("El numero es par");
         else 
            System.out.println("El numero es impar");
        
        
        System.out.println();
        System.out.println();
        //--------------------------------------------
        /* Incremento y Decremento
        Ejemplo con Incremento pero se palica en los dos 
         */
        //  PostIncremento
        
        System.out.println("PostIncremento (Variable++)");
        
        a = 5;
        System.out.println("Valor dle numero: " + a);
        var num2 = a++;
        
        System.out.println("Valor del numero despues del incremento: " + a);
        System.out.println("Valor dle numero al que se le asigna el incremento: " + num2);
        
        System.out.println();
        
        //PreIncremento
        
        System.out.println("PreIncrmeento (++Variable)");
        b = 10;
        System.out.println("Valor dle numero: " + b);
        var num3 = ++b;
        
        System.out.println("Valor del numero despues del incremento: " + b);
        System.out.println("Valor dle numero al que se le asigna el incremento: " + num3);
        
        for (int i = 0; i < 3; i++) 
            System.out.println("\n");
        
        //-----------------------------------------------------------------------------------
        
        System.out.println("Cambiar una variable booleana");
        
        var miB = true;    
        
        if(miB)
            System.out.println("Es true");
        else
            System.out.println("Es false");
        
        miB = !miB;
        
        if(miB)
            System.out.println("Es true");
        else
            System.out.println("Es false");
          

    }

}
