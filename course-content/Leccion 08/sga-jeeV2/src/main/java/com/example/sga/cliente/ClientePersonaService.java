
package com.example.sga.cliente;

import com.example.sga.domain.Persona;
import com.example.sga.service.PersonaServiceRemote;
import java.util.List;
import javax.naming.*;

public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando Servidor");
        
        try {
            Context jndi = new InitialContext();
            PersonaServiceRemote persona = (PersonaServiceRemote) jndi.lookup("java:global/sga-jeeV2/PersonaServiceImpl!com.example.sga.service.PersonaServiceRemote");
            List<Persona> personas = persona.listarPersona();
            
            for (Persona p : personas) {
                System.out.println("Nombres: " + p.getNombre());
            }
            System.out.println("Fin del programa");     
        } catch (NamingException ex) {
           ex.printStackTrace(System.out);
        }
    }
}
