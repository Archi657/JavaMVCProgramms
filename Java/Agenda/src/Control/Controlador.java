/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Modelo.Clientes;
import Modelo.Contactos;
import Vista.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {

    Formulario objetoVista;
    Contactos objetoModelo;
    Clientes objetoClientes;
    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador() {
        objetoVista = new Formulario();
        objetoModelo = new Contactos();
        objetoVista.setVisible(true);
        objetoVista.getjButton1().addActionListener(this);
    }
@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objetoVista.getjButton1()) {
            objetoClientes = new Clientes();
            objetoClientes.setNombre(objetoVista.getTxtNombre().getText());
            objetoClientes.setIdentificacion(objetoVista.getTxtIDE().getText());
            objetoClientes.setEdad(Integer.parseInt(objetoVista.getTxtEdad().getText()));
            objetoClientes.setCorreo(objetoVista.getTxtCorreo().getText());
            
            
         
            modelo = (DefaultTableModel) objetoVista.getjTable1().getModel();
            int filas = objetoVista.getjTable1().getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }

            modelo = objetoModelo.adicionar(objetoClientes);
            objetoVista.getjTable1().setModel(modelo);
            objetoVista.getTxtNombre().setText("");
            objetoVista.getTxtIDE().setText("");
            objetoVista.getTxtEdad().setText("");
            objetoVista.getTxtCorreo().setText("");
            objetoVista.getTxtNombre().requestFocus();
        }
    }

  
}
