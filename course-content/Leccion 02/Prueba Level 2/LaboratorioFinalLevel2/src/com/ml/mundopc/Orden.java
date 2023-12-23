package com.ml.mundopc;

public class Orden {

    private final int idOrden;
    private static int contadorOrden;
    private int contadorComputadoras;
    private Computadora computadoras[];

    private static final int MAX_COMPUTADORAS = 10;

    public Orden() {
        this.computadoras = new Computadora[MAX_COMPUTADORAS];
        this.idOrden = ++Orden.contadorOrden;
    }

    public void agregarComputadora(Computadora c) {
        if (this.contadorComputadoras < MAX_COMPUTADORAS) {
            this.computadoras[this.contadorComputadoras++] = c;
        } else {
            System.out.println("Haz exedido el limite: " + Orden.MAX_COMPUTADORAS);
        }

    }

    public void mostrarOrden() {
        System.out.println("*********************");
        System.out.println("Orden ID#: " + this.idOrden);
        System.out.println("*********************");
        System.out.println("Lista de Computadoras de la ORDEN");
        System.out.println("-------------------------------------------------------");
        for (Computadora c : computadoras) {
            if (c == null) {
                break;
            } else {
                System.out.println(c);
                System.out.println("-------------------------------------------------------");
            }
        }
    }

}
