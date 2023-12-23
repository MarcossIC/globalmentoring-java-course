
package personas.test;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import personas.dto.PersonaDTO;
import personas.jdbc.Conexion;
import personas.jdbc.PersonaDao;
import personas.jdbc.PersonaDaoJDBC;


public class TestPersonas {
    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            PersonaDao personaD = new PersonaDaoJDBC(conexion);
            
            List<PersonaDTO> persona = personaD.select();
            
            for (PersonaDTO p : persona) {
                System.out.println("personaDTO = " + p);
            }
            
            conexion.commit();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace(System.out);
            }
            
        }
    }
}
