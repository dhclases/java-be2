package com.dh.liquidacionsueldo.main;

import com.dh.liquidacionsueldo.main.model.Empleado;
import com.dh.liquidacionsueldo.main.model.EmpleadoEfectivo;
import com.dh.liquidacionsueldo.main.service.Liquidador;
import com.dh.liquidacionsueldo.main.service.impl.LiquidadorEmpleadoEfectivo;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Dado conciciones
        Liquidador sujetoPrueba = new LiquidadorEmpleadoEfectivo();

        Empleado empleado = new EmpleadoEfectivo("Martin", "Martini", "001ABD", 400, 60, 40);
        String resultadoEsperado = "La liquidación generada es un documento digital. Saldo a liquidar: 420";

        // Cuando
        String resultado = sujetoPrueba.liquidarSueldo(empleado);

        // Entonces o comparar resultlados

        Assertions.assertEquals(resultadoEsperado, resultado);
        System.out.println("Culminado el proceso de liquidación");


    }
}

// TODO: Junit
// TODO: Repo
// TODO: Miro
// TODO: Video: Install Junit
// TODO: Video: Install

