package model;

public class Jugador {

    private int puntos;
    private int turno;

    public Jugador() {}

    public Jugador(int puntos, int turno) {
        this.puntos = puntos;
        this.turno = turno;
    }



    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "puntos=" + puntos +
                ", turno=" + turno +
                '}';
    }
}
