/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control;

import Modelo.ModificarClientes;
import Vista.Formulario;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javax.swing.table.DefaultTableModel;


public class Controlador implements ActionListener {

    Formulario objetoVista;
    ModificarClientes objetoModelo;
    String datos[]=new String[4];

    public Controlador() {
        objetoVista = new Formulario();
        objetoModelo = new ModificarClientes();
        objetoVista.setVisible(true);
        objetoVista.getBotonsave().addActionListener(this);
        objetoVista.getBotonbuscar().addActionListener(this);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == objetoVista.getBotonsave()) {
            String nit=objetoVista.getTxtNIT().getText();
            objetoModelo.setEmpresa(objetoVista.getTxtEmpresa().getText());
            objetoModelo.setDireccion(objetoVista.getTxtDireccion().getText());
            objetoModelo.setCiudad(objetoVista.getTxtCiudad().getText());
            objetoModelo.modificar(nit);
            
        }
        
        if (e.getSource()==objetoVista.getBotonbuscar()) {
            String nit= objetoVista.getTxtNIT().getText();
            datos=objetoModelo.buscar(nit, datos);
            objetoVista.getTxtEmpresa().setText(datos[0]);
            objetoVista.getTxtDireccion().setText(datos[1]);
            objetoVista.getTxtTelf().setText(datos[2]);
            objetoVista.getTxtCiudad().setText(datos[3]);
            
        }
    }

 
}
