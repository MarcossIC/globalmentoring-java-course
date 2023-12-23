package personas.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import personas.dto.PersonaDTO;

public class PersonaDaoJDBC implements PersonaDao {

    private Connection conexionTransaccion;

    private static final String SQL_SELECT = "SELECT idpersona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE idpersona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idpersona = ?";

    public PersonaDaoJDBC() {
    }

    public PersonaDaoJDBC(Connection conexionTransaccion) {
        this.conexionTransaccion = conexionTransaccion;
    }

    @Override
    public int insert(PersonaDTO persona) throws SQLException {
        int rows = 0;

        Connection conn = this.conexionTransaccion != null ? this.conexionTransaccion : Conexion.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL_INSERT);

        ps.setString(1, persona.getNombre());
        ps.setString(2, persona.getApellido());
        ps.setString(3, persona.getEmail());
        ps.setString(4, persona.getTelefono());

        rows = ps.executeUpdate();

        try {
            Conexion.close(ps);
            if (this.conexionTransaccion == null) {
                Conexion.close(conn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return rows;
    }

    @Override
    public int update(PersonaDTO persona) throws SQLException {
        int rows = 0;

        Connection conn = this.conexionTransaccion != null ? this.conexionTransaccion : Conexion.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL_UPDATE);

        ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getEmail());
            ps.setString(4, persona.getTelefono());
            ps.setInt(5, persona.getIdPersona());

        rows = ps.executeUpdate();

        try {
            Conexion.close(ps);
            if (this.conexionTransaccion == null) {
                Conexion.close(conn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return rows;
    }

    @Override
    public int delete(PersonaDTO persona) throws SQLException {
        int rows = 0;

        Connection conn = this.conexionTransaccion != null ? this.conexionTransaccion : Conexion.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL_DELETE);

        ps.setInt(1, persona.getIdPersona());

        rows = ps.executeUpdate();

        try {
            Conexion.close(ps);
            if (this.conexionTransaccion == null) {
                Conexion.close(conn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return rows;
    }

    @Override
    public List<PersonaDTO> select() throws SQLException {
        List<PersonaDTO> personas = new ArrayList<>();
        Connection conn = this.conexionTransaccion != null ? this.conexionTransaccion : Conexion.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL_SELECT);
        ResultSet rs = ps.executeQuery();
        PersonaDTO persona = null;

        while (rs.next()) {
            persona = new PersonaDTO(
                    rs.getInt("idpersona"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getString("telefono"));

            personas.add(persona);
        }

        try {
            Conexion.close(rs);
            Conexion.close(ps);
            if (this.conexionTransaccion == null) {
                Conexion.close(conn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

        return personas;
    }

}
