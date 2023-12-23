
package com.example.sga.cliente.jpql;

import com.example.sga.domain.Persona;
import com.example.sga.domain.Usuario;
import java.util.Iterator;
import java.util.List;
import javax.persistence.*;
import org.apache.logging.log4j.*;


public class TestJPQL {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        String jpql = null;
        Query query = null;
        List<Persona> personas = null;
        Persona persona = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> nombres = null;
        List<Usuario> users = null;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        log.debug("\n1. Consulta de todas las personas");
        jpql = "SELECT p FROM Persona p";
        query = em.createQuery(jpql);
        personas = query.getResultList();
        
//        mostrarPersona(personas);
        log.debug("--------------------------------------------------------------------------------------");
        log.debug("--------------------------------------------------------------------------------------");
        jpql = "SELECT p FROM Persona p WHERE p.idPersona = 1";
        query = em.createQuery(jpql);
        persona = (Persona) query.getSingleResult();
        
//        log.debug("Persona: "+ persona);
        
        log.debug("--------------------------------------------------------------------------------------");
        log.debug("--------------------------------------------------------------------------------------");
        jpql = "SELECT p FROM Persona p WHERE p.nombre = 'Hugo'";
        query = em.createQuery(jpql);
        personas = query.getResultList();
//        log.debug("Persona: "+ persona);
        log.debug("--------------------------------------------------------------------------------------");
        log.debug("--------------------------------------------------------------------------------------");
        jpql = "SELECT p.nombre as Nombre, p.apellido as Apellido, p.email as Email FROM Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
//        while(iter.hasNext()){
//            tupla = (Object[]) iter.next();
//            String nombre = (String) tupla[0];
//            String apellido=(String) tupla[1];
//            String email  = (String) tupla[2];
//            log.debug("Datos{ Nombre: "+nombre+" Apellido: "+apellido+" Email: "+email+" }");
//        }
        log.debug("--------------------------------------------------------------------------------------");
        log.debug("--------------------------------------------------------------------------------------");
        jpql = "SELECT p, p.idPersona FROM Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
//        while(iter.hasNext()){
//            tupla = (Object[]) iter.next();
//            persona = (Persona) tupla[0];
//            int idPersona =(int) tupla[1];
//            log.debug("Persona: "+persona);
//            log.debug("ID: "+idPersona);
//            log.debug("NEXT");
//        }
        log.debug("--------------------------------------------------------------------------------------");
        log.debug("--------------------------------------------------------------------------------------");
        jpql = "SELECT new com.example.sga.domain.Persona(p.idPersona) FROM Persona p";
        personas = em.createQuery(jpql).getResultList();
//        mostrarPersona(personas);
        log.debug("--------------------------------------------------------------------------------------");
        log.debug("--------------------------------------------------------------------------------------");
        jpql = "SELECT MIN(p.idPersona) as MinId, MAX(p.idPersona) as MaxId, Count(p.idPersona) as Contador FROM Persona p";
        iter = em.createQuery(jpql).getResultList().iterator();
//        while(iter.hasNext()){
//            tupla = (Object[]) iter.next();
//            log.debug("NEXT");
//            log.debug("minId: "+tupla[0]);
//            log.debug("maxId: "+tupla[1]);
//            log.debug("Count: "+tupla[2]);
//        }
        log.debug("--------------------------------------------------------------------------------------");
        log.debug("--------------------------------------------------------------------------------------");
        jpql = "SELECT Count(DISTINCT p.nombre) FROM Persona p";
        Long contador = (Long) em.createQuery(jpql).getSingleResult();
        log.debug("Numero de personas con nombre distinto: "+contador);
        log.debug("--------------------------------------------------------------------------------------");
        log.debug("--------------------------------------------------------------------------------------");
        jpql = "SELECT CONCAT(p.nombre, ' ', p.apellido) as Nombre FROM Persona p";
        nombres = em.createQuery(jpql).getResultList();
//        for (String nombre : nombres) {
//            log.debug("NEXT");
//            log.debug("Nombre compleot: "+ nombre);
//        }
        log.debug("--------------------------------------------------------------------------------------");
        log.debug("--------------------------------------------------------------------------------------");
        jpql = "SELECT P FROM Persona p WHERE p.idPersona = :idPersona";
        query = em.createQuery(jpql);
        query.setParameter("idPersona", 19);
        persona = (Persona) query.getSingleResult();
//        log.debug("Persona: "+persona);
        log.debug("--------------------------------------------------------------------------------------");
        log.debug("--------------------------------------------------------------------------------------");
        jpql = "SELECT p FROM Persona p WHERE UPPER(p.nombre) LIKE UPPER(:parameter)";
        String filtro = "%a%";//Simbolo de porcentaje caracter para LIKE
        query = em.createQuery(jpql);
        query.setParameter("parameter", filtro);
        personas = query.getResultList();
//        mostrarPersona(personas);
        log.debug("--------------------------------------------------------------------------------------");
        log.debug("--------------------------------------------------------------------------------------");
        jpql = "SELECT p FROM Persona p WHERE P.idPersona BETWEEN 17 AND 19";
        personas = em.createQuery(jpql).getResultList();
        mostrarPersona(personas);
        log.debug("--------------------------------------------------------------------------------------");
        log.debug("--------------------------------------------------------------------------------------");
        jpql = "SELECT p FROM Persona p WHERE p.idPersona > 16 ORDER BY p.nombre DESC, p.apellido DESC";
        personas = em.createQuery(jpql).getResultList();
//        mostrarPersona(personas);
        log.debug("--------------------------------------------------------------------------------------");
        log.debug("--------------------------------------------------------------------------------------");
        jpql = "SELECT p FROM Persona p WHERE p.idPersona IN (SELECT MIN(p1.idPersona) FROM Persona p1)";
        personas = em.createQuery(jpql).getResultList();
//        mostrarPersona(personas);
        log.debug("--------------------------------------------------------------------------------------");
        log.debug("--------------------------------------------------------------------------------------");
        jpql = "SELECT u FROM Usuario u JOIN u.persona p";
        users = em.createQuery(jpql).getResultList();
//        mostrarUsuario(users);
        log.debug("--------------------------------------------------------------------------------------");
        log.debug("--------------------------------------------------------------------------------------");
        jpql = "SELECT u FROM Usuario u LEFT JOIN FETCH u.persona p";
        users = em.createQuery(jpql).getResultList();
        mostrarUsuario(users);
    }
    public static void mostrarUsuario(List<Usuario> usuarios){
        for (Usuario user : usuarios) {
            log.debug("NEXT");
            log.debug("Usuario: "+user);
        }
    }
    
    public static void mostrarPersona(List<Persona> personas){
        for (Persona persona : personas) {
            log.debug("NEXT");
            log.debug("Persona: "+persona);
        }
    }
}
