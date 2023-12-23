
package com.example.sga.cliente.ciclovidajpa;

import com.example.sga.domain.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;

public class PersistirClienteCicloVidaJTA {
    /*
        Ejemplo de las distintas acciones con Java SE 
    */
    
    //Logger para informacion ah consola uso el API log4j
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        log.debug("");
        log.debug("---------------------------------------------------------------------------");
        log.debug("Inicia el cliente");
        //Creamos el contexto
        log.debug("Creo Entity Manager Factory");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        log.debug("");
        log.debug("Creo Entity Manager");
        EntityManager em = emf.createEntityManager();
        log.debug("");
        log.debug("Creo la transaccion");
        EntityTransaction tx = em.getTransaction();
        log.debug("");
        
        //1. Se crea el objeto antes de iniciar la transaccion
        Persona persona1 = new Persona("Jair", "Wong", "jiwg@gmail.com", "543687");
        
        //2. Inicia la Transaccion
        tx.begin();
        
        //3. Ejecuta el SQL 
        em.persist(persona1);
        //En este punto no se ha guardado el objeto en la bd, tampoco se genero la clave primary del registro
        log.debug("Objeto antes del commit. " + persona1);
        //4. Commit / Rollback
        tx.commit();
        log.debug("");
        log.debug("Objeto despues del commit. " + persona1);

        em.close();
        log.debug("Fin del cliente");
    }
}
