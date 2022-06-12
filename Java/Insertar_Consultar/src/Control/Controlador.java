
package Control;

import Modelo.Clientes;
import Vista.Formulario;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {

    Formulario objetoVista;
    Clientes objetoModelo;
    DefaultTableModel modelo = new DefaultTableModel();
    int filas;

    public Controlador() {
        objetoVista = new Formulario();
        objetoModelo = new Clientes();
        objetoVista.setVisible(true);
        objetoVista.getjButton1().addActionListener(this);
        verregistros();
    }

    public void verregistros() {
        modelo = (DefaultTableModel) objetoVista.getjTable1().getModel();
        filas = objetoVista.getjTable1().getRowCount();
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
        modelo = objetoModelo.consultar();
        objetoVista.getjTable1().setModel(modelo);
        objetoModelo.contarciudades();
        objetoVista.getTxtBogota().setText(String.valueOf(objetoModelo.getBogota()));
        objetoVista.getTxtOtras().setText(String.valueOf(objetoModelo.getOtraciudad()));
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == objetoVista.getjButton1()) {
            objetoModelo = new Clientes();
            objetoModelo.setNit(objetoVista.getTxtNit().getText());
            objetoModelo.setEmpresa(objetoVista.getTxtEmpresa().getText());
            objetoModelo.setDireccion(objetoVista.getTxtDireccion().getText());
            objetoModelo.setTelefono(objetoVista.getTxtTelefono().getText());
            objetoModelo.setCiudad(objetoVista.getTxtCiudad().getText());
            objetoModelo.insertar();
            objetoVista.getTxtNit().setText("");
            objetoVista.getTxtEmpresa().setText("");
            objetoVista.getTxtDireccion().setText("");
            objetoVista.getTxtTelefono().setText("");
            objetoVista.getTxtCiudad().setText("");
            verregistros();
        }
    }
}

