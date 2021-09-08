package Controlador;

import Modelo.InsertarClientes;
import Vista.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener {

    Formulario objetoVista;
    InsertarClientes objetoModelo;

    public Control() {
        objetoVista = new Formulario();
        objetoVista.setVisible(true);
        objetoVista.getjButton1().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objetoVista.getjButton1()) {
            objetoModelo = new InsertarClientes();
            objetoModelo.setNit(objetoVista.getTxtNit().getText());
            objetoModelo.setEmpresa(objetoVista.getTxtEmpresa().getText());
            objetoModelo.setDireccion(objetoVista.getTxtDireccion().getText());
            objetoModelo.setTelefono(objetoVista.getTxtTelefono().getText());
            objetoModelo.setCiudad(objetoVista.getTxtCiudad().getText());
            
            objetoModelo.insertar();

        }
    }
}