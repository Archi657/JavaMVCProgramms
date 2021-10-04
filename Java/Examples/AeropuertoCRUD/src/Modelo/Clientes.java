
package Modelo;


public class Clientes {
    String nit,destino,direccion,telefono;

    public Clientes(String nit, String destino, String direccion, String telefono) {
        this.nit = nit;
        this.destino = destino;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    public Clientes() {
    }

    public String getNit() {
        return nit;
    }

    public void setNi(String nit) {
        this.nit = nit;
    }

    
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    

}
