package com.ml.mundopc;

public class Teclado extends DispositivoEntrada {

    private int idTeclado;
    private int contadorTeclado;

    public Teclado(String marca, String tipoEntrada) {
        super(marca, tipoEntrada);
        this.idTeclado = ++contadorTeclado;
    }

    @Override
    public String toString() {
        return "Teclado{ " + "id Teclado: " + idTeclado +  super.toString();
    }

}
