/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sga.cliente.ciclovidajpa;

import com.example.sga.domain.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;

public class EcontrarObjetoJPA {
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

        //Objeto a pasado al estado de Detached
        
        em.close();
    }
}
