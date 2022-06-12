
package Modelo;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Empleados extends Persona {

    private String cargo;
    private double salario;
    ArrayList<Empleados> empleado;
    String titulos[] = {"Nombre", "Identificación", "Cargo", "Salario"};
    DefaultTableModel modelo = new DefaultTableModel(null, titulos);

    public Empleados() {
        empleado = new ArrayList();
    }

    public Empleados(String nombre, String identificacion, String cargo, double salario) {
        super(nombre, identificacion);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public DefaultTableModel adicionar(Empleados objetonuevo) {
        empleado.add(objetonuevo);
        int i;
        Object[] fila = new Object[4];
        for (i = 0; i < empleado.size(); i++) {
            fila[0] = empleado.get(i).getNombre();
            fila[1] = empleado.get(i).getIdentificacion();
            fila[2] = empleado.get(i).getCargo();
            fila[3] = empleado.get(i).getSalario();
            modelo.addRow(fila);
        }
        return modelo;
    }
}
