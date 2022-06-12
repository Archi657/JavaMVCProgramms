/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConectarBD {

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
            conexion = DriverManager.getConnection(ruta, "root", "");
        } catch (SQLException e) {
            System.out.println("Error...:" + e);
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
}
