
package personas.test;
import java.sql.*;
import java.util.List;
import personas.dto.*;
import personas.jdbc.*;




public class TestPersonas {
    public static void main(String[] args) {
        Connection conexion = null;

        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            PersonaDao personaD = new PersonaDaoJDBC(conexion);
            
//            List<PersonaDTO> persona = personaD.select();
//            
//            for (PersonaDTO p : persona) {
//                System.out.println("personaDTO = " + p);
//            }

             personaD.update(new PersonaDTO(7, "TU MAMA", "tU PAPA", "HOLA", "1234"));
            
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
