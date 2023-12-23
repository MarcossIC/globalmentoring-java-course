
package test;

import com.example.sga.domain.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;

public class ClienteEntidadTest {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        log.debug("Iniciando Cliente");
        log.debug("");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Iniciando la transaccion
        tx.begin();
        //No especifico id ya que la base de datos lo asigna en automatico
        Persona persona1 = new Persona("Marcos", "Lopez", "lpik@gmail.com", "43235");
        log.debug(persona1);
        log.debug("");
        //Persistir el objeto
        em.persist(persona1);
        //terminando la trasaccion
        tx.commit();
        log.debug("Objeto persistido: " + persona1);
        log.debug("");
        em.close();
    }
}
