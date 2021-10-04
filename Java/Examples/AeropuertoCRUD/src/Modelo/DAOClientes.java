package Modelo;

import javax.swing.table.DefaultTableModel;


public interface DAOClientes {
    public void insertar(Clientes cliente);
    public String[] buscar(String nit, String[] datos);
    public DefaultTableModel consultar();
    public void modificar(Clientes cliente);
    public void eliminar(Clientes cliente);
}
