
package com.example.sga.service;

import com.example.sga.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote{

    @Override
    public List<Persona> listarPersona() {
        List<Persona> personas = new ArrayList<>();
        
        personas.add(new Persona(1, "Juan", "Perez", "jp@gmail.com", "4324553"));
        personas.add(new Persona(2, "Maria", "DataBase", "mariadb@gamil.com", "$32456"));
        personas.add(new Persona(3, "Max", "DataBse", "maxdb@gamil.com", "432567"));
        
        return personas;
    }

    @Override
    public Persona encontrarPersona(Persona persona) {
       return null;
    }

    @Override
    public Persona encontrarPersonaPorEmail() {
        return null;
    }

    @Override
    public Persona registrarPersona() {
        return null;
    }

    @Override
    public void modificarPersona(Persona persona) {

    }

    @Override
    public void eliminarPersona(Persona persona) {

    }
    
}
