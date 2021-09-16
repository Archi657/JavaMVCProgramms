package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConectarBD {
    String mensaje;

    public Connection conexion;
    public PreparedStatement sentencia;

    public ConectarBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo crear el puente JDBC-ODBC.");
        }
        String ruta = "jdbc:mysql://localhost/comercial";
        try {
            conexion = DriverManager.getConnection(ruta, "root","");
            mensaje = "Conexion exitosa";
        } catch (SQLException e) {
            mensaje ="error";
            System.out.println("Error...:" + e);
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}
