package com.dh.liquidacionsueldo.main.service.impl;

import com.dh.liquidacionsueldo.main.model.Empleado;
import com.dh.liquidacionsueldo.main.model.EmpleadoContratado;
import com.dh.liquidacionsueldo.main.service.Liquidador;

public class LiquidadorEmpleadoContratado extends Liquidador {


    @Override
    public String liquidarSueldo(Empleado empleado) {
        String mensajeDeRespuesta = "La liquidaciòn no pudo ser calculado";

        if(empleado instanceof EmpleadoContratado){
            EmpleadoContratado empleadoContratado = (EmpleadoContratado) empleado;
            int sueldoFinal = empleadoContratado.getHorasTrabajadas() * empleadoContratado.getValorHora();
            mensajeDeRespuesta = "La liquidación generada es un documento impreso. Saldo a liquidar: " + sueldoFinal;
        }

        return mensajeDeRespuesta;
    }
}
