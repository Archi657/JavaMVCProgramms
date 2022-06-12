
package Modelo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ProcesoUsuario extends Usuario{
    
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getConthombre() {
        return conthombre;
    }

    public void setConthombre(int conthombre) {
        this.conthombre = conthombre;
    }

    public int getContmujer() {
        return contmujer;
    }

    public void setContmujer(int contmujer) {
        this.contmujer = contmujer;
    }

    public int getCasadamujer() {
        return casadamujer;
    }

    public void setCasadamujer(int casadamujer) {
        this.casadamujer = casadamujer;
    }

    public int getSolterohombre() {
        return solterohombre;
    }

    public void setSolterohombre(int solterohombre) {
        this.solterohombre = solterohombre;
    }

    
    
    String genero,estado;
    int conthombre,contmujer,solterohombre,casadamujer;
    ArrayList <ProcesoUsuario> lista;
    String titulos[]={"Indentificacion","Nombre","Edad","Genero","Estado Civil"};
    DefaultTableModel modelo = new DefaultTableModel(null,titulos);

    public ProcesoUsuario() {
        lista= new ArrayList();
        genero ="";
        estado="";
        conthombre=0;
        contmujer=0;
        solterohombre=0;
        casadamujer=0;
        
    }

    public ProcesoUsuario(String id, String nombre, int edad, String estado, String genero) {
        super(id, nombre, edad);
        this.genero = genero;
        this.estado = estado;
        
    }
    
    public DefaultTableModel adicionar(ProcesoUsuario objnuevo){
        lista.add(objnuevo);
        int i;
        Object [] fila = new Object[5];
        for (i = 0; i< lista.size(); i++) {
            fila[0] = lista.get(i).getId();
            fila[1] = lista.get(i).getNombre();
            fila[2] = lista.get(i).getEdad();
            fila[3]= lista.get(i).getGenero();
            fila[4] = lista.get(i).getEstado();
           
            modelo.addRow(fila);
       
        }
        
         if (objnuevo.getGenero()=="Hombre") {
                conthombre+=1;
                
            }
            if (objnuevo.getEstado()=="Solter(a)" && objnuevo.getGenero()=="Hombre") {
                solterohombre+=1;
             }   
            if (objnuevo.getGenero()=="Mujer") {
                contmujer+=1;
                 
            } 
            if (objnuevo.getEstado()=="Casado(a)" && objnuevo.getGenero()=="Mujer") {
                casadamujer+=1;
            }  
        return modelo;
    }
    
    

}
