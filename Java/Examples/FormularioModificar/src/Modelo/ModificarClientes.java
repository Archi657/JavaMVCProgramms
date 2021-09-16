
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ModificarClientes {

    //DefaultTableModel modelo = new DefaultTableModel();
    String nit, empresa, direccion, telefono, ciudad;

    //public ModificarClientes() {
    //}

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

    public String[] buscar(String nit, String[] datos) {
        try {
            String criterio = nit;
            ConectarBD conexion = new ConectarBD();
            java.sql.Statement sentencia = conexion.getConexion().createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from clientes where nit='" + criterio + "'");

            while (resultado.next()) {
                datos[0] = resultado.getString("empresa");
                datos[1] = resultado.getString("direccion");
                datos[2] = resultado.getString("telefono");
                datos[3] = resultado.getString("ciudad");
            }
            resultado.close();
            conexion.getConexion().close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:" + e, "Información",
                     JOptionPane.INFORMATION_MESSAGE);

        }
        return datos;
    }

    public void modificar(String nit) {
        try {
            ConectarBD conexion = new ConectarBD();
            String instruccion = "Update clientes set empresa=?,direccion=?,telefono=?,ciudad =  ? where  nit ='" +nit+"'  ";

            conexion.sentencia = conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setString(1, getEmpresa());
            conexion.sentencia.setString(2, getDireccion());
            conexion.sentencia.setString(3, getTelefono());
            conexion.sentencia.setString(4, getCiudad());
            conexion.sentencia.execute();
            JOptionPane.showMessageDialog(null, "Registro Modificado", "Información",
                    JOptionPane.INFORMATION_MESSAGE);

            conexion.getConexion().close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL:" + e, "Información",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }
}
