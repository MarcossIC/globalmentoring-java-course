
package beans;

import javax.ejb.Remote;

@Remote
public interface EmpleadoEjbRemote {
    public String presentation();
    public double weeklySalary();
}
