package test;

import datos.*;
import domain.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestEjer {

    public static void main(String[] args) {
        UsuarioDAO userDAO = null;
        
        List<Usuario> usuarios = new ArrayList<>();
        
        Connection conexion = null;
        
        try {
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            Usuario nuevoUsuario = new Usuario("Juanito", "queteimporta");
            
            userDAO = new UsuarioDAOImp(conexion);
            userDAO.insert(nuevoUsuario);
            
            userDAO.delete(new Usuario(3));
            userDAO.delete(new Usuario(1));
            
            Usuario updateUsuario = new Usuario();
            updateUsuario.setIdUsuario(2);
            updateUsuario.setUsuario("Florencia");
            updateUsuario.setPassword("0112358");
            
            userDAO.update(updateUsuario);
            
            conexion.commit();
            
        } catch (SQLException ex) {
            
            ex.printStackTrace(System.out);
            System.out.println("Entamos al RollBack");
            
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        } finally {
            
            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
    }
}
