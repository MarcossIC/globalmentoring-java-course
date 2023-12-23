
package com.example.sga.application;

import com.example.sga.domain.PersonaDao;
import com.example.sga.domain.Persona;
import com.example.sga.domain.PersonaServiceLocal;
import com.example.sga.domain.PersonaServiceRemote;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;

@Stateless
public class PersonaServiceImpl implements PersonaServiceLocal, PersonaServiceRemote {

    @Inject
    private PersonaDao personaDao;
    
    @Resource
    private SessionContext contexto;
    
    @Override
    public List<Persona> listarPersona() {
        return personaDao.findAllPersona();
    }

    @Override
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findPersonaById(persona);
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return personaDao.findPersonaByEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
        personaDao.insertPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        try{
        personaDao.updatePersona(persona);
        } catch(Throwable t){
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarPersona(Persona persona) {
        personaDao.deletePersona(persona);
    }
    
}
