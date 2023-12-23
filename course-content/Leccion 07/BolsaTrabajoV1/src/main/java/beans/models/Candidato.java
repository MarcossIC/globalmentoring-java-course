
package beans.models;

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
    @Setter(AccessLevel.NONE) private String apellido;
    @Setter(AccessLevel.NONE) private String salarioDeseado;
    
    Logger log = LogManager.getRootLogger();
     
    public Candidato(){
        log.info("Creando candidato");
        this.setNombre("Introduce tu nombre");
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
        log.info("Modificando apellido: " + this.apellido);
    }

    public void setSalarioDeseado(String salarioDeseado) {
        this.salarioDeseado = salarioDeseado;
        log.info("Modificando salario deseado: " + this.salarioDeseado);
    }

}
