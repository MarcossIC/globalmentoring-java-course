package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.ArrayList;
import java.util.List;

public class TestManejoPersona {

    public static void main(String[] args) {
        PersonaDAO perDAO = new PersonaDAO();
        List<Persona> personas = new ArrayList<>();

        //Insertando un nuevo objeto en la base de datos
//        Persona person1 = new Persona("tu mama", "Lopez", "lopezikaro16@gmail.com", "549644100");
//        Persona person2 = new Persona(6, "carlitos", "Lopez", "lopezikaro16@gmail.com", "549644100");

//          perDAO.insertar(person1);
//        perDAO.actualizar(person2);
        perDAO.delete(new Persona(6));
        
        personas = perDAO.seleccionar();

        personas.forEach(p -> {
            System.out.println("persona: " + p);
        });

    }
}
