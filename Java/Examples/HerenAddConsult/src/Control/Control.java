package Control;

import Modelo.Empleados;
import Vista.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


public class Control implements ActionListener {

    Formulario objetoVista;
    Empleados objetoModelo;
    Empleados objetoEmpleado;
    DefaultTableModel modelo = new DefaultTableModel();

    public Control() {
        objetoVista = new Formulario();
        objetoModelo = new Empleados();
        objetoVista.setVisible(true);
        objetoVista.getBttmnopara().addActionListener(this);
        objetoVista.getBttmpara().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objetoVista.getBttmnopara()) {
            objetoEmpleado = new Empleados();
            objetoEmpleado.setNombre(objetoVista.getTxtNombre().getText());
            objetoEmpleado.setIdentificacion(objetoVista.getTxtIIDE().getText());
            objetoEmpleado.setCargo(objetoVista.getjComboBox1().getSelectedItem().toString());
            objetoEmpleado.setSalario(Double.parseDouble(objetoVista.getTxtSalario().getText()));
            modelo = (DefaultTableModel) objetoVista.getjTable1().getModel();
            int filas = objetoVista.getjTable1().getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
            modelo = objetoModelo.adicionar(objetoEmpleado);
            objetoVista.getjTable1().setModel(modelo);
        }
        
        if (e.getSource() == objetoVista.getBttmpara()) {
            String nombre = objetoVista.getTxtNombre().getText();

            String identificacion = objetoVista.getTxtIIDE().getText();
            String cargo = objetoVista.getjComboBox1().getSelectedItem().toString();
            double salario = Double.parseDouble(objetoVista.getTxtSalario().getText());
            objetoEmpleado = new Empleados(nombre, identificacion, cargo, salario);
            modelo = (DefaultTableModel) objetoVista.getjTable1().getModel();
            int filas = objetoVista.getjTable1().getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
            modelo = objetoModelo.adicionar(objetoEmpleado);
            objetoVista.getjTable1().setModel(modelo);
        }
    }
}
