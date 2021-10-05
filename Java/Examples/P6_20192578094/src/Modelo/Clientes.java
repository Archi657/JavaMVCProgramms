
package Modelo;


public class Clientes {
    int codigo,peso;
    String descripcion,origen,destino,tipo;

    public Clientes() {
    }

    public Clientes(int codigo, int peso, String descripcion, String origen, String destino, String tipo) {
        this.codigo = codigo;
        this.peso = peso;
        this.descripcion = descripcion;
        this.origen = origen;
        this.destino = destino;
        this.tipo = tipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    

}
