package Model;


public class Persona {
    String nombre;
    Fecha objFecha;

    public Persona() {
        objFecha = new Fecha();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechanacimiento() {
        return objFecha.toString();
    }

    public void setFechanacimiento(Fecha fechanacimiento) {
        this.objFecha.setDia(fechanacimiento.getDia());
        this.objFecha.setMes(fechanacimiento.getMes());
        this.objFecha.setAno(fechanacimiento.getAno());
    }   
}
