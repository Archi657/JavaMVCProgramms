package Model;


public class Fecha {
    int dia;
    int mes;
    int ano;

    public Fecha(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.ano = a;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    public String toString(){
        return ""+dia+"/"+mes+"/"+ano;
    }

}
