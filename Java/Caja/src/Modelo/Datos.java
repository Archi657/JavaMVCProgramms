
package Modelo;

public class Datos {
    double altura,ancho,profundidad;

    public Datos() {
        altura=0.0;
        ancho=0.0;
        profundidad=0.0;
    }
    
    public Datos(double altura, double ancho, double profundidad) {
        this.altura = altura;
        this.ancho = ancho;
        this.profundidad = profundidad;
    }
    
    public void iniciar(double a,double an, double p){
        altura=a;
        ancho=an;
        profundidad=p;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public double getVolumen() {
        return altura*ancho*profundidad;
    }

 
    

}
