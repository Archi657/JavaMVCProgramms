package Model;


public class Persona {
    String nombre;
    Fecha fechanacimiento;

    public Persona() {
        this.fechanacimiento = new Fecha();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechanacimiento() {
        return fechanacimiento.toString();
    }

    public void setFechanacimiento(Fecha fechanacimiento) {
        this.fechanacimiento.setDia(fechanacimiento.getDia());
        this.fechanacimiento.setMes(fechanacimiento.getMes());
        this.fechanacimiento.setAno(fechanacimiento.getAno());
    }
    
    
   
}
