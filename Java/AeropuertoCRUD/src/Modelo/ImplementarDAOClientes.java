
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public  class ImplementarDAOClientes implements DAOClientes {

    @Override
    public void insertar(Clientes cliente) {
        try {
            ConectarBD conexion = new ConectarBD();
            String instruccion = "insert into clientes values(?,?,?,?)";
            conexion.sentencia = conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setString(1, cliente.getNit());
            conexion.sentencia.setString(2, cliente.getDestino());
            conexion.sentencia.setString(3, cliente.getDireccion());
            conexion.sentencia.setString(4, cliente.getTelefono());
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
        
        try {
            ConectarBD conexion = new ConectarBD();
            String instruccion = "insert into upstring values(?,?)";
            conexion.sentencia = conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setString(1, cliente.getNit().toUpperCase());
            conexion.sentencia.setString(2, cliente.getDestino().toUpperCase());
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
        ConectarBD conexion = new ConectarBD();
        String titulos[]={"Nit","Destino","Direccion","Telefono"};
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        int cantidadColumnas=4;
        try {
            Statement sentencia = conexion.getConexion().createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from clientes");
            
            while (resultado.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[0] = resultado.getString("nit");
                    fila[1] = resultado.getString("destino");
                    fila[2] = resultado.getString("direccion");
                    fila[3] = resultado.getString("telefono");
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
     
    public String[] buscar(String nit, String[] datos) {
        try {
            String criterio = nit;
            ConectarBD conexion = new ConectarBD();
            Statement sentencia = conexion.getConexion().createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from clientes where nit ='"+criterio+"'  ");

            if (!resultado.first()) {
                JOptionPane.showMessageDialog(null, "NIT no encontrado....", "Información",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                do {
                    datos[0] = resultado.getString("destino");
                    datos[1] = resultado.getString("direccion");
                    datos[2] = resultado.getString("telefono");
                } while (resultado.next());
            }
            resultado.close();
            conexion.getConexion().close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:" + e, "Información",
                    JOptionPane.INFORMATION_MESSAGE);

        }
        return datos;
    }
    
    public void modificar(Clientes cliente) {
        try {
            ConectarBD conexion = new ConectarBD();
            String instruccion = "Update clientes set destino=?,direccion=?,telefono=? where  nit ='" +cliente.getNit()+"'  ";

            conexion.sentencia = conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setString(1, cliente.getDestino());
            conexion.sentencia.setString(2, cliente.getDireccion());
            conexion.sentencia.setString(3, cliente.getTelefono());
            conexion.sentencia.execute();
            JOptionPane.showMessageDialog(null, "Registro Modificado", "Información",
                    JOptionPane.INFORMATION_MESSAGE);

            conexion.getConexion().close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error SQL:" + e, "Información",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }
    
    public void eliminar(Clientes cliente) {
        int seleccion = JOptionPane.showOptionDialog(null,
                "¿Desea ELIMINAR ELREGISTRO(Si / No)", "Seleccione una opción",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"},
                 "Si");

        if ((seleccion + 1) == 1) {
            try {
                ConectarBD conexion = new ConectarBD();
                String instruccion = "Delete from clientes where nit=" + cliente.getNit();
                conexion.sentencia = conexion.getConexion().prepareStatement(instruccion);
                conexion.sentencia.execute();
                JOptionPane.showMessageDialog(null, "RegistroEliminado", "Información", JOptionPane.INFORMATION_MESSAGE);
                conexion.getConexion().close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ErrorSQL:" + e, "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Registro NOELIMINADO", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }


}


