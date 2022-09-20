package model;

public class Surtidor {

    private int capacidadTotal;
    private int capacidadActual;
    private String tipo;
    private boolean funciona;

    public Surtidor(int capacidadTotal, String tipo) {
        this.capacidadTotal = capacidadTotal;
        this.tipo = tipo;
        this.funciona = true;
        this.capacidadActual = capacidadTotal;
    }

    public Surtidor(String tipo) {
        this.tipo = tipo;
        this.capacidadTotal = 0;
        this.capacidadActual = 0;
        this.funciona = false;
    }

    public void arreglar(){
        this.funciona = true;
    }

    public void rellenar(int cantidad){
        this.capacidadActual += cantidad;
    }

    public void quitarGasolina(int cantidad){
        this.capacidadTotal += cantidad;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public void setCapacidadTotal(int capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    public int getCapacidadActual() {
        return capacidadActual;
    }

    public void setCapacidadActual(int capacidadActual) {
        this.capacidadActual = capacidadActual;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isFunciona() {
        return funciona;
    }

    public void setFunciona(boolean funciona) {
        this.funciona = funciona;
    }

    @Override
    public String toString() {
        return "Surtidor{" +
                "capacidadTotal=" + capacidadTotal +
                ", capacidadActual=" + capacidadActual +
                ", tipo='" + tipo + '\'' +
                ", funciona=" + funciona +
                '}';
    }
}
