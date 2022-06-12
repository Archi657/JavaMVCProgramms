

package Controlador;

import Modelo.Datos;
import Vista.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener {
    Formulario objVista;
    Datos objModel;

    public Control() {
        objVista = new Formulario();
        objVista.setVisible(true);
        objVista.getBoton().addActionListener(this);
    }
    
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==objVista.getBoton()) {
            objModel = new Datos(Double.parseDouble(objVista.getTxtR1().getText()));
            objVista.getTxtA1().setText(String.valueOf(objModel.area()));
            
            objModel = new Datos(Double.parseDouble(objVista.getTxtR2().getText()));
            objVista.getTxrA2().setText(String.valueOf(objModel.area()));
        }
    }

}
