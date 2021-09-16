
package Modelo;


public class Empleado extends Persona{
    long salario;
    int dias;

    public long getSalario() {
        return salario;
    }

    public void setSalario(long salario) {
        this.salario = salario;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
    public long calcular(){
        return ((salario/30)*dias);
    }

}
