package model;

public final class Cita {

    private int dia, mes;
    private Medico medico;
    private String comentario;

    public Cita(int dia, int mes, Medico medico, String comentario) {
        this.dia = dia;
        this.mes = mes;
        this.medico = medico;
        this.comentario = comentario;
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", medico=" + medico +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
