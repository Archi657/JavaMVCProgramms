
package Control;

import Modelo.Datos;
import Vista.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Control implements ActionListener{
    Formulario objVista;
    Datos objDatos;

    public Control() {
        objVista= new Formulario();
        objVista.setVisible(true);
        objVista.getBttmParametros().addActionListener(this);
        objVista.getBttmSinParam().addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==objVista.getBttmSinParam()) {
            objDatos = new Datos();
            double  a = Double.parseDouble(objVista.getTxtAltura().getText());
            double an= Double.parseDouble(objVista.getTxtAncho().getText());
            double p = Double.parseDouble(objVista.getTxtProfundidad().getText());
            objDatos.iniciar(a, an, p);
            objVista.getTxtVolumen().setText(String.valueOf(objDatos.getVolumen()));
            
        }
        if (e.getSource()==objVista.getBttmParametros()) {
            double  a = Double.parseDouble(objVista.getTxtAltura().getText());
            double an= Double.parseDouble(objVista.getTxtAncho().getText());
            double p = Double.parseDouble(objVista.getTxtProfundidad().getText());
            objDatos = new Datos(an, an, p);
            objVista.getTxtVolumen().setText(String.valueOf(objDatos.getVolumen()));
            
        }
    }

}
