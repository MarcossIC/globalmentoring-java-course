
package com.example.sga.cliente.criteria;

import com.example.sga.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
import org.apache.logging.log4j.*;


public class TestCriteriaAPI {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = null;
        CriteriaQuery<Persona> criteriaQuery = null;
        Root<Persona> fromPersona = null;
        TypedQuery<Persona> query = null;
        Persona persona = null;
        List<Persona> personas = null;
        
        //Consulta de todas las personas
        //1. El EnityManager crea un instancia de CriteriaBuilder
        cb = em.getCriteriaBuilder();
        
        //2. Se crea el objeto criteriaQuery
        criteriaQuery = cb.createQuery(Persona.class);
        
        //3. Objeto raiz del query
        fromPersona = criteriaQuery.from(Persona.class);
        
        //4. Seleccina lo necesario del FROM
        criteriaQuery.select(fromPersona);
        
        //5. Creamos el tipo de query
        query = em.createQuery(criteriaQuery);
        
        //6. Ejecutar consulta
        personas = query.getResultList();
//        mostrarPersona(personas);
        
        //2- A Persona con id = 1
        //jpql = "SELECT p FROM Persona p WHERE p.idPersona = 1";
        
        //Se instancia otra vez para evitar problemas
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idPersona"), 1));
        persona = em.createQuery(criteriaQuery).getSingleResult();
//        log.debug("Persona: "+persona);
        
        //2-B Consulta de la persona con id = 1
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(Persona.class);
        fromPersona = criteriaQuery.from(Persona.class);
        criteriaQuery.select(fromPersona);
        
        //1. Creo la lista de criterios
        //La clase Predicate permite agregar varios criterios dinamicamente
        List<Predicate> criterios = new ArrayList<Predicate>();
        
        
        //Verificamos si tenemos criterios que agregar
        //2. Objeto le paso el valor con el que quiero comparar este debe de ser del mismo tipo que su version 
        //      en la clase
        Integer idPersonaParam = 19;
        
        //3. Creo el parametro pasandole la clase a la que pertence en este caso Integer
        //      Tambien le paso el nombre del prametro como String
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idPersona");
        
        //4. Añade el criterio a la lista pasandole el atributo "idPersona" de la clase Persona
        //      y le digo que el atributo tiene que ser igua lal parametro que cree
        criterios.add(cb.equal(fromPersona.get("idPersona"), parameter));
        
        //Añado al Query los citerios
        if(criterios.size() > 1){
            //Con este sentencia concateno los parametros que quiero de la lista de criterios al WHERE 
            //      de la sentencia. Esto es si tienes mas de uno y quieres poner uno en especifico 
            criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
        }
        if(criterios.size() == 1){
            //Concateno al WHERE el criterio. En este caso entra si solo tengo un criterio por eso solo pongo
            //  get con parametro 0 
            criteriaQuery.where(criterios.get(0));
        }
        if(criterios.isEmpty()){
            //Una excepcion ya que no puede estar vacio
            throw new RuntimeException("Sin criterios");
        }
        
        query = em.createQuery(criteriaQuery);
        query.setParameter("idPersona", idPersonaParam);
        persona = query.getSingleResult();
        log.debug("Perosna: "+persona);
        
    }
    public static void mostrarPersona(List<Persona> personas){
        for (Object persona1 : personas) {
            log.debug("NEXT");
            log.debug("Persona: "+persona1);
        }
    }
        
}
