package Modelo;
public class Datos {
    double radio;

    public Datos(double r) {
        radio = r;
    }
    public double area(){
        return 4.0 * 3.14159 * radio;
    }
}
