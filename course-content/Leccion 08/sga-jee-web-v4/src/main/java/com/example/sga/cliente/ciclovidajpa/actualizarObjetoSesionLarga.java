package com.example.sga.cliente.ciclovidajpa;

import com.example.sga.domain.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;

public class actualizarObjetoSesionLarga {
    /*
        Ejemplo de las distintas acciones con Java SE 
            No se suele utilizar la sesion larga pero un ejemplo de como es
     */
    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        log.debug("");
        log.debug("-----------------------------------------------------------------------");
        log.debug("Inicia el cliente");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        log.debug("");

        //1. Inicie transaccion uno
        tx.begin();
        
        //2. Ejecuto SQL Select
        Persona persona1 = em.find(Persona.class, 1);

        //3. Modificacion
        persona1.setApellido("rmrr@gmail.com");

        //4. Podes hacer mas de una modificacion por X motivo
        persona1.setApellido("rm-rmaster@gmail.com");
        //como estoy dentro de la transaccion no hace falta el merge
        //merge sincroniza y aqui como no cierro la transaccion siguen sincronizados 
        
        log.debug("Objeto modificado: " + persona1);

        //5. Fin de la transaccion
        tx.commit();
        em.close();
        log.debug("Fin del cliente");
    }
}
