package Control;

import Modelo.Conductor;
import Modelo.Taxi;
import Vista.FormularioAsociacionClases;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorConductorTaxi implements ActionListener {

    FormularioAsociacionClases objetoVista;
    Conductor objetoConductor;
    Taxi objetoTaxi;

    public ControladorConductorTaxi() {
        objetoVista = new FormularioAsociacionClases();
        objetoVista.setVisible(true);
        objetoVista.getjButton1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objetoVista.getjButton1()) {
            String conductor = objetoVista.getTxtconductor().getText();
            objetoConductor = new Conductor(conductor);
            String matricula = objetoVista.getTxtmatricula().getText();
            objetoTaxi = new Taxi(objetoConductor, matricula);
            objetoVista.getTxtconductortaxi().setText("" + objetoTaxi.getChofer());
            objetoVista.getTxtmatriculataxi().setText("" + objetoTaxi.getMatricula());
        }
    }
}
