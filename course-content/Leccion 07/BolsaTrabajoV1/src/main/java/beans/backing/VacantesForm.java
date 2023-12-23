
package beans.backing;

import beans.models.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import jdk.nashorn.internal.objects.NativeError;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class VacantesForm {
    
        @Inject
 @Setter private Candidato candidato;

    Logger log = LogManager.getRootLogger();
    
    public VacantesForm(){
        log.info("Creando el objeto de Vacante Form");
    }
    
    
    
    public String enviar(){
        if(!this.candidato.getNombre().equals("Juan")){
            log.info("Caso de fallo");
            return "fallo";
        }
        if(this.candidato.getNombre().equals("Juan")){
            if(this.candidato.getApellido().equals("Perez")){
                String msg = "Gracais pero Juan Perez ya trabaja con nosotros";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componentId = null;
                facesContext.addMessage(componentId, facesMessage);
                return "index";
            }
            return "exito";
        }
        
        throw new NullPointerException("No tendria que estar aqui");
    }
    
}
