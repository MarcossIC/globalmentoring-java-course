
package beans.backing;

import beans.models.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jdk.nashorn.internal.objects.NativeError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class vacantesForm {
    
    @Inject
    private Candidato candidato;

    Logger log = LogManager.getRootLogger();
    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    public String enviar(){
        if(!this.candidato.getNombre().equals("Juan")){
            log.info("Caso de fallo");
            return "fallo";
        }
        if(this.candidato.getNombre().equals("Juan")){
            log.info("Caso de exito");
            return "exito";
        }
        
        throw new NullPointerException("No tendria que estar aqui");
    }
    
}
