
package beans;

import javax.ejb.Stateless;

@Stateless
public class EmpleadoEjbImpl implements EmpleadoEjbRemote{

    private String name;
    private String lastName;
    private double salaryPerMonth;
    
    @Override
    public String presentation() {
        System.out.println("Ejecucion del metodo");
        return "HolaMundo JavaEE me llamo: " + this.name + " " + this.lastName;
    }

    @Override
    public double weeklySalary() {
        System.out.println("Ejecucion del metodo weeklySalary");
        this.salaryPerMonth = 500;
        return salaryPerMonth / 4;
    }
    
}
