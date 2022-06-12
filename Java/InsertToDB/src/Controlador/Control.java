
package Controlador;

import Modelo.Funciones;
import Vista.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;


public class Control implements ActionListener{
    Formulario objetoVista;
    Funciones objetoModelo;
    DefaultListModel modeloa = new DefaultListModel();
    DefaultListModel modelob = new DefaultListModel();

    public Control() {
        objetoVista = new Formulario();
        objetoVista.setVisible(true);
        objetoVista.getjButton1().addActionListener(this);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == objetoVista.getjButton1()){
           String cadena = objetoVista.getTxtEntrada().getText();
           objetoModelo = new Funciones(cadena);
           modeloa.clear();
           modelob.clear();
           modeloa= objetoModelo.separara();
           modelob= objetoModelo.separarb();
           objetoVista.getListainvert().setModel(modeloa);
           objetoVista.getLista().setModel(modelob);
         }
    }


}
