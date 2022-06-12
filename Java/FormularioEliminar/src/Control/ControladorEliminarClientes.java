
package Control;

import Modelo.EliminarClientes;
import Vista.Formulario1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class ControladorEliminarClientes implements ActionListener {

    Formulario1 objetoVista;
    EliminarClientes objetoModelo;
    DefaultTableModel modelo = new DefaultTableModel();
    String datos[] = new String[4];

    public ControladorEliminarClientes() {
        objetoVista = new Formulario1();
        objetoModelo = new EliminarClientes();
        objetoVista.setVisible(true);
        objetoVista.getBotonsave().addActionListener(this);
        objetoVista.getBotonbuscar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objetoVista.getBotonsave()) {
            String nit = objetoVista.getTxtNIT().getText();
            objetoModelo.eliminar(nit);
            objetoVista.getTxtNIT().setText("");
            objetoVista.getTxtEmpresa().setText("");
            objetoVista.getTxtDireccion().setText("");
            objetoVista.getTxtTelf().setText("");
            objetoVista.getTxtCiudad().setText("");
        }
        if (e.getSource() == objetoVista.getBotonbuscar()) {
            String nit = objetoVista.getTxtNIT().getText();

            datos = objetoModelo.buscar(nit, datos);
            objetoVista.getTxtEmpresa().setText(datos[0]);
            objetoVista.getTxtDireccion().setText(datos[1]);
            objetoVista.getTxtTelf().setText(datos[2]);
            objetoVista.getTxtCiudad().setText(datos[3]);
        }
    }
}
