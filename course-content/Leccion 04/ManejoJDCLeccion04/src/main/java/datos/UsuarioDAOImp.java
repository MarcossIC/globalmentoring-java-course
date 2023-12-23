package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import domain.Usuario;
import java.sql.*;
import java.util.*;

public class UsuarioDAOImp implements UsuarioDAO {

    Connection conexionTransaccion;

    private static String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario";
    private static String SQL_INSERT = "INSERT INTO usuario(usuario, password) VALUES(?, ?)";
    private static String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE id_usuario = ?";
    private static String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";

    public UsuarioDAOImp() {

    }

    public UsuarioDAOImp(Connection conexionTransaccion) {
        this.conexionTransaccion = conexionTransaccion;
    }

    @Override
    public List<Usuario> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Usuario user = null;
        List<Usuario> users = new ArrayList<>();

        try {
            conn = this.conexionTransaccion != null ? this.conexionTransaccion : getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                user = new Usuario(rs.getInt("id_usuario"), rs.getString("usuario"), rs.getString("password"));
                users.add(user);
            }

        } finally {
            try {
                close(rs);
                close(stmt);
                if (this.conexionTransaccion == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return users;
    }

    @Override
    public int insert(Usuario user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccion != null ? this.conexionTransaccion : getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, user.getUsuario());
            stmt.setString(2, user.getPassword());

            registros = stmt.executeUpdate();

        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccion == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }

    @Override
    public int update(Usuario user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccion != null ? this.conexionTransaccion : getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, user.getUsuario());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getIdUsuario());

            registros = stmt.executeUpdate();

        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccion == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }

        return registros;
    }

    @Override
    public int delete(Usuario user) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.conexionTransaccion != null ? this.conexionTransaccion : getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, user.getIdUsuario());

            registros = stmt.executeUpdate();

        } finally {
            try {
                close(stmt);
                if (this.conexionTransaccion == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;

    }

}
