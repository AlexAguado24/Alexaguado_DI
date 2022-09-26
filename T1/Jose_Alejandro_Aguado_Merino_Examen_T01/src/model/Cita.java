package model;

public class Cita {

    private String dia, mes, cometario;
    private Medico medico;

    public Cita() {
    }

    public Cita(String dia, String mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public Cita(String dia, String mes, String cometario, Medico medico) {
        this.dia = dia;
        this.mes = mes;
        this.cometario = cometario;
        this.medico = medico;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getCometario() {
        return cometario;
    }

    public void setCometario(String cometario) {
        this.cometario = cometario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "dia='" + dia + '\'' +
                ", mes='" + mes + '\'' +
                ", cometario='" + cometario + '\'' +
                ", medico=" + medico +
                '}';
    }
}
