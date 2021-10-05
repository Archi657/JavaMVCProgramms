package Control;

import Modelo.Clientes;
import Modelo.ImplementarDAOClientes;
import Vista.FormularioCRUD;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class ControladorCRUD implements ActionListener {

    FormularioCRUD objetoVista;
    ImplementarDAOClientes objetoModelo;
    Clientes objetoClientes;
    DefaultTableModel modelo = new DefaultTableModel();

    String nit, empresa, direccion, telefono, ciudad;
    int filas;
    String datos[] = new String[4];

    public ControladorCRUD() {
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
        objetoVista.getTxtValorterrestres().setText(String.valueOf(objetoModelo.getTerrestresval()));
            objetoVista.getTxtValorAereos().setText(String.valueOf(objetoModelo.getAereosval()));
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

        
        if (e.getSource() == objetoVista.getBtnnuevo()) {
            objetoClientes.setCodigo(Integer.parseInt(objetoVista.getTxtnit().getText()));
            objetoClientes.setDescripcion(objetoVista.getjComboBoxDescripcion().getSelectedItem().toString());
            objetoClientes.setOrigen(objetoVista.getTxtorigen().getText());
            objetoClientes.setDestino(objetoVista.getTxtdestino().getText());
            objetoClientes.setTipo(objetoVista.getjComboBoxTipo().getSelectedItem().toString());
            objetoClientes.setPeso(Integer.parseInt(objetoVista.getTxtpeso().getText()));
            objetoModelo.insertar(objetoClientes);
        //    objetoVista.getTxtValorterrestres().setText(String.valueOf(objetoModelo.getTerrestresval()));
        //    objetoVista.getTxtValorAereos().setText(String.valueOf(objetoModelo.getAereosval()));
            
            
            objetoVista.getTxtnit().setText("");
            objetoVista.getTxtorigen().setText("");
            objetoVista.getTxtdestino().setText("");
            objetoVista.getTxtpeso().setText("");
            
            
  
            verregistros();
        }
        if (e.getSource() == objetoVista.getBtnbuscar()) {
            String nit = objetoVista.getTxtnit().getText();
            datos = objetoModelo.buscar(nit, datos);
            objetoVista.getjComboBoxDescripcion().setName(datos[0]);
            objetoVista.getTxtorigen().setText(datos[1]);
            objetoVista.getTxtdestino().setText(datos[2]);
           objetoVista.getjComboBoxTipo().setName(datos[3]);
           objetoVista.getTxtpeso().setText(datos[4]);
      //     objetoVista.getTxtValorterrestres().setText(String.valueOf(objetoModelo.getTerrestresval()));
       //     objetoVista.getTxtValorAereos().setText(String.valueOf(objetoModelo.getAereosval()));
          
        }
        if (e.getSource() == objetoVista.getBtnmodificar()) {
            objetoClientes.setCodigo(Integer.parseInt(objetoVista.getTxtnit().getText()));
            objetoClientes.setDescripcion(objetoVista.getjComboBoxDescripcion().getSelectedItem().toString());
            objetoClientes.setOrigen(objetoVista.getTxtorigen().getText());
            objetoClientes.setDestino(objetoVista.getTxtdestino().getText());
           objetoClientes.setTipo(objetoVista.getjComboBoxTipo().getSelectedItem().toString());
            objetoClientes.setPeso(Integer.parseInt(objetoVista.getTxtpeso().getText()));
         
            objetoModelo.modificar(objetoClientes);
           
            verregistros();
    //        objetoVista.getTxtValorterrestres().setText(String.valueOf(objetoModelo.getTerrestresval()));
      //      objetoVista.getTxtValorAereos().setText(String.valueOf(objetoModelo.getAereosval()));
        }
        if (e.getSource() == objetoVista.getBtneliminar()) {
            objetoClientes.setCodigo(Integer.parseInt(objetoVista.getTxtnit().getText()));
            objetoModelo.eliminar(objetoClientes);
            objetoVista.getTxtnit().setText("");
            objetoVista.getTxtorigen().setText("");

            objetoVista.getTxtdestino().setText("");
            objetoVista.getTxtpeso().setText("");
            
            verregistros();
       //     objetoVista.getTxtValorterrestres().setText(String.valueOf(objetoModelo.getTerrestresval()));
         //   objetoVista.getTxtValorAereos().setText(String.valueOf(objetoModelo.getAereosval()));
        }
                
    }
}
