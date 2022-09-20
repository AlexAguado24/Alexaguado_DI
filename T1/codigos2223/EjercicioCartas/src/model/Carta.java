package model;

public class Carta {

    private int valor;
    private String palo;

    public Carta() {}

    public Carta(int valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public void mostrarDatos(){
        System.out.println(getValor() +" "+getPalo());
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "valor=" + valor +
                ", palo=" + palo +
                '}';
    }
}
