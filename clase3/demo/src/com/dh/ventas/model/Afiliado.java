package com.dh.ventas.model;

public class Afiliado extends Vendedor {

    public Afiliado(String nombre){
        super.nombre = nombre;
        super.PUNTOS_DE_VENTA = 15;
    }

    @Override
    public int calcularPuntos() {
        return this.ventas * PUNTOS_DE_VENTA;
    }
}
