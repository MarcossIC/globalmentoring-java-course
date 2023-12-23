package moda.paquete1;

public class Clase1 {

    //-------------------------------------------------------
    public String atributoP = "Atributo publico";

    protected String atributoProtected = "Atributo Protected";

    private String atributoPrivado = "Atributo privado";

    //-------------------------------------------------------
    public Clase1(String arg) {
        System.out.println("Constructor publico");
    }

    protected Clase1(String arg, String arg2) {
        this();
        System.out.println("Contructor Protected");
        
        
    }

    private Clase1() {
        System.out.println("LLamando al constructor privado por el protegido");
    }

    //-------------------------------------------------------
    public void metodoPublico() {
        System.out.println("Se ejecuta el metodo publico");
    }

    protected void metodoProtected() {
        System.out.println("Metodo Protected");
    }

    private void metodoPrivado() {
        System.out.println("Metodo privado");
    }

    //-------------------------------------------------------
}
