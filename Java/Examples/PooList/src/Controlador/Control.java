
package Controlador;

import Modelo.Datos;
import Modelo.Factura;
import Vista.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Control implements ActionListener{
    Formulario objVista;
    Factura objFact;
    Datos objDatos;
    DefaultTableModel modelo = new DefaultTableModel();

    public Control() {
        objVista = new Formulario();
        objFact = new Factura();
        objVista.setVisible(true);
        objVista.getjButton1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        objDatos = new Datos();
        
        objDatos.setNombre(objVista.getjComboBox1().getSelectedItem().toString());
        objDatos.setCantidad(Float.parseFloat(objVista.getTxtCantidad().getText()));
        objDatos.setPrecio(Float.parseFloat(objVista.getTxtValor().getText()));
        
        modelo=(DefaultTableModel) objVista.getTabla().getModel();
        int filas= objVista.getTabla().getRowCount();
        for (int i = 0; i<filas; i++) {
            modelo.removeRow(0);
        }
            modelo= objFact.adicionar(objDatos);
            objVista.getTabla().setModel(modelo);
            
    }
}
