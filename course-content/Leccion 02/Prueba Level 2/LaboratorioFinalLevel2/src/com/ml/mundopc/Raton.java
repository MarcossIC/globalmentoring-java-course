package com.ml.mundopc;

public class Raton extends DispositivoEntrada {

    private int idRaton;
    private int contadorRatones;

    public Raton(String marca, String tipoEntrada) {
        super(marca, tipoEntrada);
        this.idRaton = ++contadorRatones;
    }

    @Override
    public String toString() {
        return "Raton{ " + "idRaton: " + idRaton +  super.toString();
    }

}
