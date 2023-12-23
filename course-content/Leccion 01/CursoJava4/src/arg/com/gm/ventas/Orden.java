
package arg.com.gm.ventas;


public class Orden {
    
    private int idOrden;
    private Producto productos[];
    private static int contadorOrden;
    private int contadorProductos;
    private static final int MAX_PRODUCTOS = 10;
    
    public Orden(){
        contadorProductos = 0;
        this.idOrden = ++Orden.contadorOrden;
        this.productos = new Producto[MAX_PRODUCTOS];
    }
    
    public void agregarProducto(Producto p){
        if(this.contadorProductos < Orden.MAX_PRODUCTOS){
            this.productos[this.contadorProductos++] = p;  
        } else {
            System.out.println("Ya tiene el maximo de productos en la Orden");
        }
    }
    
    public void removeProducto(int indiceProductos){
        productos[indiceProductos] = null; 
        contadorProductos--;  
    }
    
    public double calcularTotal(){ 
        double total = 0;
        for (int i = 0; i < this.contadorProductos; i++){
            total += productos[i].getPrecio();
        }
        
        return total;
    }
    
    public void mostrarOrden(){

        System.out.println("*******************************");
        System.out.println("Id de la Orden: " + this.idOrden);
        System.out.println("Total de la Orden: $" + this.calcularTotal());
        System.out.println("*********************************************************");
        System.out.println("LISTA DE PRODUCTOS");
        for (var p : productos) {  
            System.out.println(p.toString());  
        }
        System.out.println("*********************************************************");
    }
        
}
