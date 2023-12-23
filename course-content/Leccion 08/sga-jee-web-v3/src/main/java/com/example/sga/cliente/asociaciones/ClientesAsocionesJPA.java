package com.example.sga.cliente.asociaciones;

import com.example.sga.domain.Persona;
import com.example.sga.domain.Usuario;
import java.util.List;
import javax.persistence.*;
import lombok.Cleanup;
import org.apache.logging.log4j.*;

public class ClientesAsocionesJPA {

    static Logger log = LogManager.getRootLogger();

    /*
        Ejemplo de Asociaciones Tipo Lazy e Eager con JPA
            En este caso asocio persona con usuario
    Lazy: Es la consulta por default, lo que hace es hacer la consulta SQL asociada al momento de necesitarla
            Ejemplo al hacer un select All de Persona este Lista a todas las personas, pero no hace la consulta
            para recuperar los usuarios relacionados, esta consulta se hace al momento de que llames al metodo.
             Esta forma mejora el rendimiento
    Eager: Se debe especificar que la usas, a diferencia de lazy llama todas las consultas asociadas al mismo 
           tiempo. 
            Ejemplo: Este no va esperar a que llames a la lista de Usuarios al momento de hacer el Select 
            de personas ya hace el select de Usuario. Esto obviamente quita el rendimiento si es que listas todo
    
        Esto se puede especificar en la clase Entidad (domain)
     */

    public static void main(String[] args) {
        log.debug("-----------------------------------------------------------------------------------------------------------------------------------------------------");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        log.debug("-----------------------------------------------------------------------------------------------------------------------------------------------------");
        @Cleanup
        EntityManager em = emf.createEntityManager();
        log.debug("-----------------------------------------------------------------------------------------------------------------------------------------------------");
        //No hace falta iniciar una transaccion 
        //Las transacciones se hacen 
         //1- Se va ejecutar mas de una consutla 
         //2-Se cambia el estado de la base de datos
        log.debug("-----------------------------------------------------------------------------------------------------------------------------------------------------");
        List<Persona> listaPersona = em.createNamedQuery("Persona.findAll").getResultList();
        log.debug("-----------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Persona persona : listaPersona) {
            log.debug("Persona: " + persona);
            //Uuario de cada persona
            for (Usuario usario : persona.getUsuarioList()) {
                log.debug("Usuario Asociado: " + usario);
            }
            log.debug("-----------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
