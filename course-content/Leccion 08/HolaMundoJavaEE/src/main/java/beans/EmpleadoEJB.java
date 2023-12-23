
package beans;

import javax.ejb.Stateless;
import lombok.*;

@Stateless
@Getter @Setter
public class EmpleadoEJB {
    private String name;
    private String lastName;
    private double salaryPerMonth;
    
    public String presentacion(){
        return "Hola JavaEE me llamo: " + this.getName(); 
    }
    
    public String weeklySalary(){
        return "Por semana cobra: " +this.getSalaryPerMonth() / 4;
    } 
}
