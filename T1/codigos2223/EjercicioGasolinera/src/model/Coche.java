package model;

public class Coche {

    private String tipoGasolina;
    private int litrosDeposito;

    public Coche(String tipoGasolina) {
        this.tipoGasolina = tipoGasolina;
        this.litrosDeposito = 0;
    }

    public void ponerGasolina(Surtidor surtidor, int cantidadLitros){
        //surtidor.quitarGasolina(cantidadLitros);
        if (surtidor.getCapacidadActual()  <= cantidadLitros){
            System.out.println("El surtidor no tiene tantos litros para repostar");
        } else if (!surtidor.isFunciona()) {
            System.out.println("Surtidor averiado");
        } else if (!surtidor.getTipo().equalsIgnoreCase(getTipoGasolina())) {
            System.out.println("La gasolina que necesita el coche es de otro tipo");
        } else {
            System.out.println("Listros repostados");
            setLitrosDeposito(cantidadLitros);
            surtidor.setCapacidadActual(surtidor.getCapacidadActual()-cantidadLitros);
        }
    }

    public String getTipoGasolina() {
        return tipoGasolina;
    }

    public void setTipoGasolina(String tipoGasolina) {
        this.tipoGasolina = tipoGasolina;
    }

    public int getLitrosDeposito() {
        return litrosDeposito;
    }

    public void setLitrosDeposito(int litrosDeposito) {
        this.litrosDeposito = litrosDeposito;
    }
}
