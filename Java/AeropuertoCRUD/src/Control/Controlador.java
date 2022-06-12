package Control;

import Modelo.Clientes;
import Modelo.ImplementarDAOClientes;
import Vista.FormularioCRUD;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {

    FormularioCRUD objetoVista;
    ImplementarDAOClientes objetoModelo;
    Clientes objetoClientes;
    DefaultTableModel modelo = new DefaultTableModel();

    String nit, empresa, direccion, telefono, ciudad;
    int filas;
    String datos[] = new String[4];

    public Controlador() {
         objetoVista = new FormularioCRUD();
        objetoModelo = new ImplementarDAOClientes();
        objetoClientes = new Clientes();
        objetoVista.setVisible(true);
        objetoVista.getBtnnuevo().addActionListener(this);
        objetoVista.getBtnbuscar().addActionListener(this);
        objetoVista.getBtnmodificar().addActionListener(this);
        objetoVista.getBtneliminar().addActionListener(this);
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
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == objetoVista.getBtnnuevo()) {
            objetoClientes.setNi(objetoVista.getTxtnit().getText());
            objetoClientes.setDestino(objetoVista.getTxtdestino().getText());
            objetoClientes.setDireccion(objetoVista.getTxtdireccion().getText());
            objetoClientes.setTelefono(objetoVista.getTxttelefono().getText());
            objetoModelo.insertar(objetoClientes);
            objetoVista.getTxtnit().setText("");
            objetoVista.getTxtdestino().setText("");
            objetoVista.getTxtdireccion().setText("");
            objetoVista.getTxttelefono().setText("");
            verregistros();
        }
        if (e.getSource() == objetoVista.getBtnbuscar()) {
            String nit = objetoVista.getTxtnit().getText();
            datos = objetoModelo.buscar(nit, datos);
            objetoVista.getTxtdestino().setText(datos[0]);
            objetoVista.getTxtdireccion().setText(datos[1]);
            objetoVista.getTxttelefono().setText(datos[2]);
            
        }
        if (e.getSource() == objetoVista.getBtnmodificar()) {
            objetoClientes.setNi(objetoVista.getTxtnit().getText());
            objetoClientes.setDestino(objetoVista.getTxtdestino().getText());
            objetoClientes.setDireccion(objetoVista.getTxtdireccion().getText());
            objetoClientes.setTelefono(objetoVista.getTxttelefono().getText());
            objetoModelo.modificar(objetoClientes);
            verregistros();
        }
        if (e.getSource() == objetoVista.getBtneliminar()) {
            objetoClientes.setNi(objetoVista.getTxtnit().getText());
            objetoModelo.eliminar(objetoClientes);
            objetoVista.getTxtnit().setText("");
            objetoVista.getTxtdestino().setText("");

            objetoVista.getTxtdireccion().setText("");
            objetoVista.getTxttelefono().setText("");
            verregistros();
        }
    }
}
