
package com.example.sga.cliente.ciclovidajpa;

import com.example.sga.domain.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;


public class EliminaObjetoJPA {
    /*
        Ejemplo de las distintas acciones con Java SE 
    */
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        //Creamos el contexto
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        //1. Inicia la Transaccion
        tx.begin();

        //2. Se ejecuta el SQL
        Persona persona1 = em.find(Persona.class, 2);
        
        //3. Termina la trasaccion
        tx.commit();

        //Objeto a pasado al estado de detached
        
        EntityTransaction tx2 = em.getTransaction();
        //4. Inicia la transaccion 2
        tx2.begin();
        //Como la transaccion anterior termino se desincronaron los objetos
        //5. Entonces lo volves a sincronizar con merge
        em.merge(persona1);
        
        //6. Una vez sincronizado ya haces el remove
        em.remove(persona1);
        
        //7. Fin transaccion 2 Commit / Rollback
        tx2.commit();
        em.close();
    }
}
