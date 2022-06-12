
package Control;

import Modelo.ConectarBD;
import Vista.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador implements ActionListener{
    Formulario objVista;
    ConectarBD objModelo;

    public Controlador() {
        objVista = new Formulario();
        objVista.setVisible(true);
        objVista.getjButton1().addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==objVista.getjButton1()) {
            objModelo = new ConectarBD();
            objVista.getjTextField1().setText(objModelo.getMensaje());
        }
    }

}
