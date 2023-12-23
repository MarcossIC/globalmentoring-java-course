
package test;

import java.sql.*;


public class TestMySQL {
    public static void main(String[] args) {
        var url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection conexion = DriverManager.getConnection(url, "root", "admin");

           Statement instruccion = conexion.createStatement();
           var sql = "SELECT idpersona, nombre, apellido, email, telefono FROM persona";
           ResultSet resultado = instruccion.executeQuery(sql);
           while(resultado.next()){
               System.out.println("************************");
               System.out.println("id persona: " + resultado.getInt("idpersona"));
               System.out.println("Nombre: " + resultado.getString("nombre"));
               System.out.println("apellido: " + resultado.getString("apellido"));
               System.out.println("email: " + resultado.getString("email"));
               System.out.println("telefono: " + resultado.getString("telefono"));
               System.out.println("************************");
           }
           resultado.close();
           instruccion.close();
           conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

}
