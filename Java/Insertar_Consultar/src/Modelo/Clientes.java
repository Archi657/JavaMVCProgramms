

package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Clientes {

    String nit, empresa, direccion, telefono, ciudad;
    int bogota,otraciudad;
    

    public Clientes() {
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getBogota() {
        return bogota;
    }

    public void setBogota(int bogota) {
        this.bogota = bogota;
    }

    public int getOtraciudad() {
        return otraciudad;
    }

    public void setOtraciudad(int otraciudad) {
        this.otraciudad = otraciudad;
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
/*
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
    }*/
    public void contarciudades(){
        ConectarBD conexion= new ConectarBD();
        try{
            Statement sentencia = conexion.getConexion().createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from clientes");
            while(resultado.next()){
                String registro="";
                registro = resultado.getString("ciudad");
                if (registro.equalsIgnoreCase("Bogotá")) {
                    bogota+=1;
                }else{
                    otraciudad+=1;
                }
            }
        resultado.close();;
        conexion.getConexion().close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error:"+e,"Informacion",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public DefaultTableModel consultar() {
        ConectarBD conexion = new ConectarBD();
        String titulos[]={"Nit","Empresa","Direccion","Telefono","Ciudad"};
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        int cantidadColumnas=5;
        try {
            Statement sentencia = conexion.getConexion().createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from clientes");
            
            while (resultado.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[0] = resultado.getString("nit");
                    fila[1] = resultado.getString("empresa");
                    fila[2] = resultado.getString("direccion");
                    fila[3] = resultado.getString("telefono");
                    fila[4] = resultado.getString("ciudad");
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

