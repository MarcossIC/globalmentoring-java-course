
package com.example.sga.cliente.cascade;

import com.example.sga.domain.Persona;
import com.example.sga.domain.Usuario;
import javax.persistence.*;
import lombok.Cleanup;
import org.apache.logging.log4j.*;


public class PersistenciaCascadaJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        @Cleanup EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        //Objetos en estado transitivo
        Persona persona = new Persona("Hugo", "Gonzales", "hg-gz@gamil.com", "75215");
        Usuario user = new Usuario("ElCojeAbuelas", "contraseña", persona);
        
        //Al persistir el usuario al estar activada la persistencia en cascada
        //Y en automatico persiste el objeto persona y tambien crea los id de ambos automaticamente
        em.persist(user);

        tx.commit();
        //Objetos en estado de detach
        log.debug("Persona: "+ persona);
        log.debug("Usuario: "+ user);
    }
}
