
package beans.models;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class Candidato {
    @Getter @Setter
    private String nombre = "Introduce tu nombre";
}
