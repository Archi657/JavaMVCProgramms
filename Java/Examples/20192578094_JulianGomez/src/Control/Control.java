

package Control;

import Modelo.Revision;
import Vista.Formulario1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;


public class Control implements ActionListener{
    Formulario1 objVista;
    Revision objModelo;
    Revision objCliente;
    DefaultTableModel modelo = new DefaultTableModel();

    public Control() {
        objVista = new Formulario1();
        objVista.setVisible(true);
        objVista.getjButton1().addActionListener(this);
        objModelo = new Revision();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        String nom = objVista.getTxtNombre().getText();
        String ide = objVista.getTxtIdentificacion().getText();
        String pla = objVista.getTxtPlaca().getText();
        String mod = objVista.getTxtModelo().getText();
        String rev = objVista.getjComboBox1().getSelectedItem().toString();
       // objModelo.setEstado(rev);
        
        objCliente = new Revision(ide, nom, pla, mod, rev);
        
        modelo = (DefaultTableModel) objVista.getjTable1().getModel();
        int filas = objVista.getjTable1().getRowCount();
        for (int j = 0; j < filas; j++) {
           modelo.removeRow(0);
        }
        
        modelo = objModelo.adicionar(objCliente);
        objVista.getjTable1().setModel(modelo);
        
        objVista.getTxtRevAprobadas().setText(""+objModelo.getContaprobado());
        objVista.getTxtRevMantenimiento().setText(""+objModelo.getContmantenimiento());
        objVista.getTxtRevRechazadas().setText(""+objModelo.getContrechazado());
        DecimalFormat formato = new DecimalFormat("#,###,###.##");
        objVista.getTxtValorRecaudado().setText("$"+formato.format(objModelo.getContrecaudado()));
        
        
        objVista.getTxtNombre().setText("");
        objVista.getTxtPlaca().setText("");
        objVista.getTxtIdentificacion().setText("");
        objVista.getTxtModelo().setText("");
        
    }

}
