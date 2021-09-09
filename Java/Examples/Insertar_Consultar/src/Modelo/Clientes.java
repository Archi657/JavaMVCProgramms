

package Modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Clientes {

    String nit, empresa, direccion, telefono, ciudad;

    public Clientes() {
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
            JOptionPane.showMessageDialog(null, "Registro Insertado", "Información",
                    JOptionPane.INFORMATION_MESSAGE);

            conexion.getConexion().close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL" + e, "Información",
                    JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error del sistema" + e, "Información",
                    JOptionPane.ERROR_MESSAGE);

        }
    }

    public DefaultTableModel consultar() {
        DefaultTableModel modelo = new DefaultTableModel();
        ConectarBD conexion = new ConectarBD();
        try {
            Statement sentencia = conexion.getConexion().createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from clientes");
            ResultSetMetaData campos = resultado.getMetaData();
//La cantidad de columnas que tiene la consulta
            int cantidadColumnas = campos.getColumnCount();
//Establecer como cabeceras el nombre de las columnas
            for (int i = 1; i <= cantidadColumnas; i++) {
                modelo.addColumn(campos.getColumnLabel(i));
            }
//Creando las filas para el JTable
            while (resultado.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = resultado.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            resultado.close();
            conexion.getConexion().close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error:" + e, "Informacion",
                    JOptionPane.INFORMATION_MESSAGE);

        }
        return modelo;
    }
}

