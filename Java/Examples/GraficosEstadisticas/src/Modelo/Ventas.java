
package Modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Ventas {

    String[] titulos = {"Nombre", "Cantidad", "Precio"};
    DefaultTableModel modelo = new DefaultTableModel(null, titulos);
    String nombre, cantidad, precio;
    JPanel panelgrafico;

    public Ventas() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void insertar() {
        try {
            ConectarBD conexion = new ConectarBD();
            String instruccion = "insert into ventas values(?,?,?)";
            conexion.sentencia = conexion.getConexion().prepareStatement(instruccion);
            conexion.sentencia.setString(1, getNombre());
            conexion.sentencia.setString(2, getCantidad());
            conexion.sentencia.setString(3, getPrecio());
            conexion.sentencia.execute();
            JOptionPane.showMessageDialog(null, "Registro Insertado", "Información",JOptionPane.INFORMATION_MESSAGE);

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
        try {
            Statement sentencia = conexion.getConexion().createStatement();
            ResultSet resultado = sentencia.executeQuery("select * from ventas");
            ResultSetMetaData campos = resultado.getMetaData();
            int cantidadColumnas = campos.getColumnCount();
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

    public JFreeChart Graficar() {
        JFreeChart grafica = null;
        ConectarBD conexion = new ConectarBD();
        try {
            Statement sentencia;
            ResultSet resultado = null;
            sentencia = conexion.getConexion().createStatement();
            resultado = sentencia.executeQuery(
            "select nombre, sum(cantidad) as alias from ventas group by nombre");
            DefaultCategoryDataset conjuntodatos = new DefaultCategoryDataset();
            while (resultado.next()) {
                conjuntodatos.setValue(resultado.getInt("alias"), "Ventas",
                resultado.getString("nombre"));
            }
            grafica = ChartFactory.createBarChart3D("Ventas de Productos","Frutas","Cantidad",conjuntodatos,PlotOrientation.VERTICAL,false,true, false);
        }
            catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error:" + e, "Informacion",
                    JOptionPane.INFORMATION_MESSAGE);

        }
        return grafica;
    }
}
