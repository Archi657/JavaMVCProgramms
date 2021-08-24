
package Modelo;

import javax.swing.DefaultListModel;

public class Funciones {
      int contador=0;
      int cantidad;
      String palabraIn="";
      char[] palabraArray;

      String cadena;
      DefaultListModel modeloa = new DefaultListModel();
      DefaultListModel modelob = new DefaultListModel();

      public Funciones(String micadena) {
	     cadena = micadena;
      }
      
   public DefaultListModel separara() {
	     String palabras[] = cadena.split(" ");
	     for (String palabra : palabras) {

		    if(palabra.charAt(0)=='c' || palabra.charAt(0)=='C'){
                        cantidad= palabra.length();
                        palabraArray= new char [cantidad];
                        palabraArray = palabra.toCharArray();
                        for (int i=(palabraArray.length-1); i>-1;i--){
                            palabraIn=palabraIn+palabraArray[i];
                        }

			modeloa.addElement(palabraIn);   
                        palabraIn="";
		    }
		    
	     }
	     return modeloa;
      }
    public DefaultListModel separarb() {
	     String palabras[] = cadena.split(" ");
	     for (String palabra : palabras) {
		    if(palabra.contains("a")||palabra.contains("A")){
			modelob.addElement(palabra);   
			contador++;
		    }
		    
	     }
	     return modelob;
      }

      
}