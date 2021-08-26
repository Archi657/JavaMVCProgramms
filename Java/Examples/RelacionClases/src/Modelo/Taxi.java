package Modelo;

public class Taxi {

    private Conductor chofer;
    private String matricula;

    public Taxi(Conductor chofer, String matricula) {
        this.chofer = chofer;
        this.matricula = matricula;
    }

    public String getChofer() {
        return this.chofer.getNombre();
    }

    public void setChofer(Conductor chofer) {
        this.chofer = chofer;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

