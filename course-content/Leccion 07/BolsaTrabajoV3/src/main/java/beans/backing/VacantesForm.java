
package beans.backing;

import beans.models.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
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
    
    
    public String respuesta(){
        switch(this.candidato.getNombre()){
            case "Juan":
                if(this.candidato.getApellido().equals("Perez")){
                    String msg = "Gracais pero Juan Perez ya trabaja con nosotros";
                    FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    String componentId = null;
                    facesContext.addMessage(componentId, facesMessage);
                    return "index";
                }
                return "exito";
            case "Marcos":
                if(this.candidato.getSalarioDeseado() == 25){
                    String msg = "Gracias " + this.candidato.getNombre() + " pero pides demasiado";
                    FacesMessage faceMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
                    FacesContext faceContext = FacesContext.getCurrentInstance();
                    faceContext.addMessage(null, faceMessage);
                    return "index";
                }
                return "exito"; 
            case "Roberto":  
              if(this.candidato.getApellido().equals("Roman")){
                  return "exito"; 
              }
              return "fallo"; 
            default: 
                return "fallo";  
        }
    }
}
