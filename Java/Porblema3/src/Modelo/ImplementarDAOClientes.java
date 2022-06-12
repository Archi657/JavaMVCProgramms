
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public  class ImplementarDAOClientes implements DAOClientes {
    
    int terrestresval,aereosval;

    public ImplementarDAOClientes() {
        terrestresval=0;
        aereosval=0;
    }
   

    public int getTerrestresval() {
        return terrestresval;
    }

    public void setTerrestresval(int terrestresval) {
        this.terrestresval = terrestresval;
    }

    public int getAereosval() {
        return aereosval;
    }

    public void setAereosval(int aereosval) {
        this.aereosval = aereosval;
    }
    

    @Override
    public void insertar(Clientes cliente) {
        try {
            ConectarBD conexion = new ConectarBD();
            String instruccion = "insert into informacion values(?,?,?,?,?,?)";
            conexion.sentencia = conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setInt(1, cliente.getCodigo());
            conexion.sentencia.setString(2, cliente.getDescripcion());
            conexion.sentencia.setString(3, cliente.getOrigen());
            conexion.sentencia.setString(4, cliente.getDestino());
            conexion.sentencia.setString(5, cliente.getTipo());
            conexion.sentencia.setInt(6, cliente.getPeso());
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
        String titulos[]={"Código","Destino","Origen","Destino","Tipo","Peso","Valor"};
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        int cantidadColumnas=7;
        aereosval=0;
        terrestresval=0;
        try {
            Statement sentencia = conexion.getConexion().createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from informacion");
            
            while (resultado.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[0] = resultado.getString("codigo");
                    fila[1] = resultado.getString("descripcion");
                    fila[2] = resultado.getString("origen");
                    fila[3] = resultado.getString("destino");
                    fila[4] = resultado.getString("tipo");
                    fila[5] = resultado.getString("peso");
                    
                    
                }
                if(!"Aereo".equals(resultado.getString("tipo"))){
                        fila[6] = Integer.parseInt(resultado.getString("peso"))*6000;
                        aereosval=aereosval+Integer.parseInt(fila[6].toString());
                        System.out.println("tipo aereo");
                    }else if(!"Terrestre".equals(resultado.getString("tipo"))){
                        fila[6] = Integer.parseInt(resultado.getString("peso"))*12000;
                        terrestresval=terrestresval+Integer.parseInt(resultado.getString("peso"))*12000;
                        System.out.println("tipo terrestre");
                    }
                modelo.addRow(fila);
            }
            resultado.close();
            conexion.getConexion().close();
            System.out.println("a "+ aereosval +" t " + terrestresval);
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
            ResultSet resultado = sentencia.executeQuery("select * from informacion where codigo ='"+criterio+"'  ");

            if (!resultado.first()) {
                JOptionPane.showMessageDialog(null, "NIT no encontrado....", "Información",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                do {
                    datos[0] = resultado.getString("descripcion");
                    datos[1] = resultado.getString("origen");
                    datos[2] = resultado.getString("destino");
                    datos[3] = resultado.getString("tipo");
                    datos[4] = resultado.getString("peso");
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
            String instruccion = "Update informacion set descripcion=?,origen=?,destino=?,tipo=?,peso=? where  codigo ='" +cliente.getCodigo()+"'  ";

            conexion.sentencia = conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setString(1, cliente.getDescripcion());
            conexion.sentencia.setString(2, cliente.getOrigen());
            conexion.sentencia.setString(3, cliente.getDestino());
            conexion.sentencia.setString(4, cliente.getTipo());
            conexion.sentencia.setInt(5, cliente.getPeso());
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
                String instruccion = "Delete from informacion where codigo=" + cliente.getCodigo();
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


