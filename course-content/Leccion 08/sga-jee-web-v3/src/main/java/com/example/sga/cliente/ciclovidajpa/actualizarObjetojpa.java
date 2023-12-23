
package com.example.sga.cliente.ciclovidajpa;

import com.example.sga.domain.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;


public class actualizarObjetojpa {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        log.debug("");
        log.debug("-----------------------------------------------------------------------");
        log.debug("Inicia el cliente");
        //Creamos el contexto
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        log.debug("");

        //1. Se inicia la trasaccion
        tx.begin();
        
        //2. Se ejecuta el sql | pasa al estado trasitivo
        Persona persona1 = em.find(Persona.class, 1);
        
        //3. Commit / Rollback
        tx.commit();

        //4. Hago la modificacion | Objeto pasa al estado de detached
        persona1.setApellido("Ramirez");
        
        //5. Creo una segunda trasaccion
        EntityTransaction tx2 = em.getTransaction();
        
        //6.  Inicio la segunda transaccion
        tx2.begin();
        
        //7. Se ejecuta SQL merge que sincroniza los objetos
        em.merge(persona1);
        
        //8. Commit / Roll back
        tx2.commit();
        
        //Objeto vuelve al estado de detach pero ya esta modificado 
        em.close();
        
        log.debug("Fin del cliente");
    }
}
