package Modelo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Contactos {

    ArrayList<Clientes> clientes;
    String titulos[] = {"Nombre", "Identificación", "Edad", "Correo electronico"};
    DefaultTableModel modelo = new DefaultTableModel(null, titulos);

    public Contactos() {
        clientes = new ArrayList();
    }

    public DefaultTableModel adicionar(Clientes objetonuevo) {
        clientes.add(objetonuevo);
        int i;
        Object[] fila = new Object[4];

        for (i = 0; i < clientes.size(); i++) {
            fila[0] = clientes.get(i).getNombre();
            fila[1] = clientes.get(i).getIdentificacion();
            fila[2] = clientes.get(i).getEdad();
            fila[3] = clientes.get(i).getCorreo();
            modelo.addRow(fila);
        }
        return modelo;
    }
}
