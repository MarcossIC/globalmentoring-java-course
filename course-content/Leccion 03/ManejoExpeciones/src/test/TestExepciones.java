
package test;


import static aricmetica.Aricmetica.division;
import exepcion.OperacionExepcion;


public class TestExepciones {
    public static void main(String[] args) {
        int resultado = 0;
        
        try{
        resultado = division(10, 0);
        
        }catch(OperacionExepcion e){
            System.out.println("Ocurrio un error de tipo: Operacion Exception");
        }catch(Exception e){ 
            System.out.println("Ocurrio un error de tipo: Exeption");
            e.printStackTrace(System.out);
        }
        finally{
            System.out.println("Se reviso la  division entre cero");
        }
        
       System.out.println("resultado = " + resultado);
       
    }
    
}
