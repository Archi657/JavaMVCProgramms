
package Modelo;

public class Cliente {
    String Id,nombre,placa,modelo,estado;

    public Cliente() {
    }

    public Cliente(String Id, String nombre, String placa, String modelo, String estado) {
        this.Id = Id;
        this.nombre = nombre;
        this.placa = placa;
        this.modelo = modelo;
        this.estado = estado;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

}
