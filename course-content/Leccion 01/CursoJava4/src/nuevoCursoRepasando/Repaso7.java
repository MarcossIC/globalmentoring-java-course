
package nuevoCursoRepasando;


public class Repaso7 {
    public static void main(String[] args) {
        //Vairable Local
        //esta se almacena en la Memoria Stack
        var a = 10;
        var b = 5;
        
        //Variable Object Se almacena en la memoria Heap
        Aricmetica calculo = new Aricmetica();
        Aricmetica calculo2 = new Aricmetica(10, 5);
        
        calculo.a = 3;
        calculo.b = 2;
        
        var result = calculo.sumaConRetorno();
        
        System.out.println("result = " + result);
        
        result = calculo.sumaConArgumento(5, 8);
        
        System.out.println("result = " + result);
    }
    
    public static void miMetodo(){
        //a = 10;  No se puede porque no existe en este metodo
        System.out.println("Mi metodo");
    }
}

class Aricmetica{
    
    int a;
    int b;
    
    public Aricmetica(){
        System.out.println("Ejecutando Constructor");
        
    }
    
    public Aricmetica(int a, int b){
        
        this.a = a;
        this.b = b;
        System.out.println("Ejecutando constructor con argumentos");
    }
    
    public int sumaConRetorno(){
        
        return a + b;
    }
    
    public int sumaConArgumento(int a, int b){
        this.a = a;
        this.b = b;
        
        return this.sumaConRetorno();
    }
}
