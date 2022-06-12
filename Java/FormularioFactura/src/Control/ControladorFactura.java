
import Vista.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


public class ControladorFactura implements ActionListener {

    Formulario objetoVista;
    Factura objetoModelo;
    Datos objetoDatos;
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorFactura() {
        objetoVista = new Formulario();
        objetoModelo = new Factura();
        objetoVista.setVisible(true);
        objetoVista.getBotonadicionar().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objetoVista.getBotonadicionar()) {
            objetoDatos = new Datos();
            objetoDatos.setNombre(objetoVista.getListaproductos().getSelectedItem().toString());
            objetoDatos.setPrecio(Float.parseFloat(objetoVista.getTxtvalor().getText()));
            objetoDatos.setCantidad(Float.parseFloat(objetoVista.getTxtcantidad().getText()));
            modelo = (DefaultTableModel) objetoVista.getTabla().getModel();
            int filas = objetoVista.getTabla().getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
            modelo = objetoModelo.adicionar(objetoDatos);
            objetoVista.getTabla().setModel(modelo);
        }
    }

   
}
