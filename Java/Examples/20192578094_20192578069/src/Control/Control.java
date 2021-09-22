
package Control;

import Modelo.ProcesoUsuario;
import Modelo.Usuario;
import Vista.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Control implements ActionListener{
    Formulario objVista;
    ProcesoUsuario objModelo;
    ProcesoUsuario objModelo2;
    String genero;
    DefaultTableModel modelo = new DefaultTableModel();

    public Control() {
        objVista = new Formulario();
        objVista.setVisible(true);
        objVista.getjButton1().addActionListener(this);
        objModelo = new ProcesoUsuario();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==objVista.getjButton1()) {
            

            String n = objVista.getTxtNombre().getText();
            int ed = Integer.parseInt(objVista.getTxtEdad().getText());
            String i = objVista.getTxtIdentificacion().getText();
            
            String estado = objVista.getjComboBox1().getSelectedItem().toString();
            objModelo.setEstado(estado);
            
            if (objVista.getjRadioButton1().isSelected()==true) {
                genero = objVista.getjRadioButton1().getText();
            }
            if (objVista.getjRadioButton2().isSelected()==true) {
                genero = objVista.getjRadioButton2().getText();
            }
            
            objModelo.setGenero(genero);  
            objModelo2 = new ProcesoUsuario(i, n, ed, estado, genero);

            modelo = (DefaultTableModel) objVista.getjTable1().getModel();
            int filas = objVista.getjTable1().getRowCount();
            for (int j = 0; j < filas; j++) {
                modelo.removeRow(0);
            }

            modelo = objModelo.adicionar(objModelo2);
            objVista.getjTable1().setModel(modelo);
            
            objVista.getTxtTotalhombres().setText(""+objModelo.getConthombre());
            objVista.getTxtTotalmujeres().setText(""+objModelo.getContmujer());
            objVista.getTxtHombressolteros().setText(""+objModelo.getSolterohombre());
            objVista.getTxtMujerescasadas().setText(""+objModelo.getCasadamujer());
            
            objVista.getTxtNombre().setText("");
            objVista.getTxtIdentificacion().setText("");
            objVista.getTxtEdad().setText("");

            
        }
   
    }

}
