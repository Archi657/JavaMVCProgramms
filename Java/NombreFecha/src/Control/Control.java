package Control;

import Model.Fecha;
import Model.Persona;
import View.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener{
    
    Fecha objFecha;
    Persona objPersona;
    Formulario objVista;

    public Control() {
        objVista= new Formulario();
        objVista.setVisible(true);
        objVista.getjButton1().addActionListener(this);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==objVista.getjButton1()){
            objPersona = new Persona();
            objPersona.setNombre(objVista.getTxtNombre().getText());
            int dia= Integer.parseInt(objVista.getTxtDia().getText());
            int mes = Integer.parseInt(objVista.getTxtMes().getText());
            int ano = Integer.parseInt(objVista.getTxtAno().getText());
            
            objFecha = new Fecha(dia, mes, ano);
            objPersona.setFechanacimiento(objFecha);
            objVista.getTxtNombreFInal().setText(""+objPersona.getNombre());
            objVista.getTxtFecha().setText(""+objPersona.getFechanacimiento());
        }
    }
    

}
