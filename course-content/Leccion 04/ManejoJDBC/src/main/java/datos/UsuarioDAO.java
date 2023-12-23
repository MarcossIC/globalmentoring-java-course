
package datos;

import domain.Usuario;
import java.sql.SQLException;
import java.util.List;


public interface UsuarioDAO {
    
    public List<Usuario> seleccionar() throws SQLException;
    
    public int insertar(Usuario user)throws SQLException;
    
    public int actualizar(Usuario user)throws SQLException;
    
    public int delete(Usuario user)throws SQLException;
}
