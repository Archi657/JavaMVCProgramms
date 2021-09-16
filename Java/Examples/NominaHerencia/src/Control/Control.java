
package Control;

import Modelo.Nomina;
import Vista.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener{
    Formulario objVista;
    Nomina objNom;

    public Control() {
        objVista= new Formulario();
        objVista.setVisible(true);
        objVista.getjButton1().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==objVista.getjButton1()) {
            objNom= new Nomina();
            objNom.setNombre(objVista.getTxtNombre().getText());
            objNom.setId(objVista.getTxtNombre().getText());
            objNom.setSalario(Long.parseLong(objVista.getjComboBox1().getSelectedItem().toString()));
            objNom.setDias(Integer.parseInt(objVista.getTxtDias().getText()));
            
            objVista.getjTextArea1().setText("");
            objVista.getjTextArea1().append("Información Nomina: \n");
            objVista.getjTextArea1().append("=================================\n");
            objVista.getjTextArea1().append("Nombre Empleado:"+ objNom.getNombre() + "\n");
            objVista.getjTextArea1().append("Id. Empleado:" + objNom.getId() + "\n");
            objVista.getjTextArea1().append("Salario Básico:"+ objNom.getSalario() + "\n");
            objVista.getjTextArea1().append("Dias Trabajados:" + objNom.getDias() + "\n");
            objVista.getjTextArea1().append("+ Auxilio de transporte:"+ objNom.auxiliot() + "\n");

            objVista.getjTextArea1().append("- Salud:" + objNom.salud() + "\n");

            objVista.getjTextArea1().append("- Pensión::"  + objNom.pension() + "\n");
            objVista.getjTextArea1().append("=================================\n");
            objVista.getjTextArea1().append("Neto a Pagar:"+ objNom.calcularsalario() + "\n");
            
        }
        
    }
    

}
