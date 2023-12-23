
package beans.models;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
@Getter @Setter
public class Candidato {
    
    private String nombre;
    private String apellido;
    private int salarioDeseado;
    private Date fechaNacimiento;
    
    Logger log = LogManager.getRootLogger();
     
}
