package test;

import datos.UsuarioDAO;
import datos.UsuarioDAOImp;
import domain.Usuario;
import java.util.ArrayList;
import java.util.List;

public class TestEjer {

    public static void main(String[] args) {
        UsuarioDAOImp userDAO = new UsuarioDAOImp();
        List<Usuario> usuarios = new ArrayList<>();

//        Usuario user1 = new Usuario("Marcos", "12345");
//        Usuario user2 = new Usuario("Ayelen", "87421");
//        Usuario user3 = new Usuario("Luis", "98765");
        Usuario user4 = new Usuario("Imanol", "tumama");
//        
//        userDAO.insertar(user1);
//        userDAO.insertar(user2);
//        userDAO.insertar(user3);
        userDAO.insertar(user4);

//         userDAO.delete(new Usuario(9));
//         userDAO.delete(new Usuario(10));
//         userDAO.delete(new Usuario(11));
//         userDAO.delete(new Usuario(12));
        
        usuarios = userDAO.seleccionar();
        
        for (Usuario u : usuarios) {
            System.out.println("usuario = " + u);
        }
        


    }
}
