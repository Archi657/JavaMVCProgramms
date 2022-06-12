

package Modelo;

public class Nomina extends Empleado{
    public long auxiliot(){
        long auxilio=0;
        if (this.salario<(2*737117)) {
            auxilio=(83140/30)*this.getDias();
        }else{
            auxilio=0;
        }
        return auxilio;
    }
    public long salud(){
        return (long) (super.calcular()*0.03);
    }
    public long pension(){
        return (long) (super.calcular()*0.04);
    }
    public long calcularsalario(){
        return super.calcular()+auxiliot()-salud()-pension();
    }
}

