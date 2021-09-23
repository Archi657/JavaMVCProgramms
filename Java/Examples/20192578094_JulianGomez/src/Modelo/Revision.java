
package Modelo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class Revision extends Cliente{

    public int getValorrev() {
        return valorrev;
    }

    public void setValorrev(int valorrev) {
        this.valorrev = valorrev;
    }

    public int getContaprobado() {
        return contaprobado;
    }

    public void setContaprobado(int contaprobado) {
        this.contaprobado = contaprobado;
    }

    public int getContrechazado() {
        return contrechazado;
    }

    public void setContrechazado(int contrechazado) {
        this.contrechazado = contrechazado;
    }

    public int getContmantenimiento() {
        return contmantenimiento;
    }

    public void setContmantenimiento(int contmantenimiento) {
        this.contmantenimiento = contmantenimiento;
    }

    public int getContrecaudado() {
        return contrecaudado;
    }
    
    
    
    int valorrev,contrecaudado;
    int contaprobado,contrechazado,contmantenimiento;
    
    
    ArrayList <Revision> lista;
    String titulos[]={"Indentificacion","Cliente","Placa","Modelo","Revision","Valor"};
    DefaultTableModel modelo = new DefaultTableModel(null,titulos);

    public Revision() {
        lista= new ArrayList();
        valorrev=0;
        contaprobado=0;
        contrechazado=0;
        contmantenimiento=0;
        contrecaudado=0;
    }

    public Revision(String Id, String nombre, String placa, String modelo, String estado) {
        super(Id, nombre, placa, modelo, estado);
    }

    
    
    
    
    public DefaultTableModel adicionar(Revision objnuevo){
        lista.add(objnuevo);
        
        int i;
        Object [] fila = new Object[6];
        for (i = 0; i< lista.size(); i++) {
            fila[0] = lista.get(i).getId();
            fila[1] = lista.get(i).getNombre();
            fila[2] = lista.get(i).getPlaca();
            fila[3]= lista.get(i).getModelo();
            fila[4] = lista.get(i).getEstado(); 
            if (lista.get(i).getEstado()=="Aprobado") {
                //contaprobado+=1;
                valorrev= 250000;
                fila[5]= valorrev;
            }
            if (lista.get(i).getEstado()=="Rechazado") {
                valorrev = 100000;
                //contrechazado+=1;
                fila[5]= valorrev;
             }   
            if (lista.get(i).getEstado()=="Mantenimiento") {
                //contmantenimiento+=1;
                valorrev=500000;
                fila[5]= valorrev; 
            } 
            
           
            modelo.addRow(fila);
       
        }
        
         if (objnuevo.getEstado()=="Aprobado") {
                contaprobado+=1;
                contrecaudado+=valorrev;
            }
            if (objnuevo.getEstado()=="Rechazado") {
                contrechazado+=1;
                contrecaudado+=valorrev;
             }   
            if (objnuevo.getEstado()=="Mantenimiento") {
                contmantenimiento+=1;
                contrecaudado+=valorrev;
            } 
         
        return modelo;
    }
    
    

}
