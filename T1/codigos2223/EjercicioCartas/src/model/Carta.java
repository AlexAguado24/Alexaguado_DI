package model;

public class Carta {

    private String valor;

    public Carta() {}

    public Carta(String valor) {
        this.valor = valor;
    }

    public void mostrarDatos(){
        System.out.println(getValor());
    }


    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "valor='" + valor + '\'' +
                '}';
    }
}
