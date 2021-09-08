
package Modelo;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class InsertarClientes {
    String nit,empresa,direccion,telefono,ciudad;

    public InsertarClientes() {
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public void insertar() {
        try {
            ConectarBD conexion = new ConectarBD();

            String instruccion = "insert into clientes values(?,?,?,?,?)";
            conexion.sentencia = conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setString(1, getNit());
            conexion.sentencia.setString(2, getEmpresa());
            conexion.sentencia.setString(3, getDireccion());
            conexion.sentencia.setString(4, getTelefono());
            conexion.sentencia.setString(5, getCiudad());
            conexion.sentencia.execute();
            JOptionPane.showMessageDialog(null, "Registro Insertado",
                    "Información", JOptionPane.INFORMATION_MESSAGE);

            conexion.getConexion().close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL" + e,
               "Información", JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error del sistema" + e,
                "Información", JOptionPane.ERROR_MESSAGE);
        }

    }
}
