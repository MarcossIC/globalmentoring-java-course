
package com.example.sga.cliente;

import com.example.sga.domain.Persona;
import com.example.sga.service.PersonaServiceRemote;
import javax.naming.*;
import org.apache.logging.log4j.*;

public class TestTransacciones {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote personService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web-v5/PersonaServiceImpl!com.example.sga.service.PersonaServiceRemote");
            log.debug("Iniciando prueba manejo Transaccional Persona Service");
            Persona persona1 = personService.encontrarPersona(new Persona(18));
            log.debug("Persona: "+persona1);
            persona1.setApellido("Buitrez");
            personService.modificarPersona(persona1);
            log.debug("Objeto modificado: "+persona1);
            log.debug("Fin de prueba");
        } catch (NamingException ex) {
            log.debug(ex.getMessage());
        }
    }
}
