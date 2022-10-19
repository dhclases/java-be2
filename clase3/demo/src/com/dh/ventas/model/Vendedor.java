package com.dh.ventas.model;

/*
Una empresa de ventas digitales nos pide modificar el modelado de su sistema.
El sistema permite clasificar a los Vendedores en base al cumplimiento de ciertos requisitos.
Se debe considerar los siguientes aspectos;

Para cada Empleado o Afiliado devolverá una categoría según su rendimiento
de ventas: novato, aprendiz, bueno, maestro.

Los Vendedores suman puntos positivos según alcancen ciertos objetivos.

El objetivo de los Empleados es conseguir Afiliados y hacer Ventas,
conseguirán 10 puntos por cada nuevo afiliado, 5 puntos por cada venta que realicen y 5 puntos extra por cada anio de antiguedad que posean.

El objetivo de los Afiliados es hacer ventas, conseguirán 15 puntos por cada
nueva venta.

Los Vendedores se categorizan de la siguiente manera:

Menos de 20 puntos = novatos.
Entre 20 y 30 puntos = aprendices.
Entre 31 y 40 puntos = buenos.
Más de 40 puntos = maestros.

Se nos solicita crear un tercer tipo de vendedor llamado Pasante, los Pasantes se categorizan según los siguientes aspectos:

El objetivo de los Pasantes es hacer ventas, por cada venta reciben 5 puntos.

Los pasantes categorizaran de la siguiente manera:

Menos de 50 puntos = pasante novato.
50 puntos o mas = pasante experimentado.


EJEMPLOS DE SALIDA:
“Juan tiene un total de 22 puntos, categoriza como aprendiz.”
“Pedro tiene un total de 9 puntos, categoriza como novato.”
“Mauricio tiene un total de 55 puntos, categoriza como pasante experimentado.”

*/
//validacion que use propiedades de las subclases solamente!!
//Clase abstracta Vendedor, aqui va el metodo TEMPLATE


public abstract class Vendedor {

    protected String nombre;
    protected int ventas;
    protected int PUNTOS_DE_VENTA;

    // validar que sea abstracto y lo implementa en las superclases

    public void vender(int cantVentas){
        this.ventas += cantVentas;
    }

    /*
        Metodo que calcula los puntos del Vendedor segun sus aspectos a considerar
        */

    public abstract int calcularPuntos();

    /*
       METODO TEMPLATE - recibe los puntos totales calculados desde la subclase
       y valida cada item para devolver la categoria
    */

    public String mostrarCategoria(){
        int puntosDelVendedor = calcularPuntos();
        return this.nombre + " tiene un total de " + puntosDelVendedor + " puntos y categoriza como "+ getNombreCategorias();
    }

    public String getNombreCategorias(){
        int puntosVendedor = calcularPuntos();
        if(puntosVendedor < 20){
            return "novato";
        }else if (puntosVendedor < 31){
            return "aprendiz";
        }else if (puntosVendedor < 41){
            return "bueno";
        } else {
            return "maestro";
        }
    }






}





