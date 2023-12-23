
package datos;

import domain.Usuario;
import java.sql.SQLException;
import java.util.List;


public interface UsuarioDAO {
    
    public List<Usuario> select() throws SQLException;
    
    public int insert(Usuario user)throws SQLException;
    
    public int update(Usuario user)throws SQLException;
    
    public int delete(Usuario user)throws SQLException;
}
