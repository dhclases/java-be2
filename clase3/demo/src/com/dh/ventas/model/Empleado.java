package com.dh.ventas.model;

import java.util.ArrayList;

public class Empleado  extends Vendedor  {
    private int aniosSAntiguedad;
    private ArrayList<Vendedor> afiliados = new ArrayList<>();

    public Empleado(String nombre, int aniosSAntiguedad){
        super.nombre = nombre;
        super.PUNTOS_DE_VENTA = 5;
        this.aniosSAntiguedad = aniosSAntiguedad;
    }




    /*
      Agrega un afiliado al empleado, y a su vez suma los puntos
     */
    public void agregarAfiliado(Vendedor afiliado){
        this.afiliados.add(afiliado);
    }


    /*
       implementacion de metodo abstracto
       por cada anio de antiguedad obtiene 5 puntos, por cada afiliado obtiene 5
    */


    @Override
    public int calcularPuntos() {
        return (this.afiliados.size()*10) + this.aniosSAntiguedad*5;
    }

}
