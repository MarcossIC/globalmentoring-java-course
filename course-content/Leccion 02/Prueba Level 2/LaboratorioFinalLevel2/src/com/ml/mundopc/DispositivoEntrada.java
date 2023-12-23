package com.ml.mundopc;

public class DispositivoEntrada {

    private String tipoEntrada;
    private String marca;

    public DispositivoEntrada(String marca, String tipoEntrada) {
        this.marca = marca;
        this.tipoEntrada = tipoEntrada;
    }

    @Override
    public String toString() {
        return ", Tipo de Entrada: " + tipoEntrada + ", Marca: " + marca + " }";
    }

    public String getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(String tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}
