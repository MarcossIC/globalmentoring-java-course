
package arg.com.peliculas.vista;

import javax.swing.JFrame;


public class Marco extends JFrame{
   
    public Marco(){
        this.iniMarco();
        
    }
    
    private void iniMarco(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Proyecto Final Udemy Agregado");
        setSize(600, 500);
        setLocationRelativeTo(null);
           
        add(new Panel());
    }
    
}
