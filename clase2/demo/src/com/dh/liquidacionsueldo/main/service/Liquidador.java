package com.dh.liquidacionsueldo.main.service;

import com.dh.liquidacionsueldo.main.model.Empleado;

public abstract  class Liquidador {
    // Método template o plantilla
    public abstract String liquidarSueldo(Empleado empleado);

    public String depositarSueldo(Empleado empleado){
        return "Sueldo depositado en la cuenta " + empleado.getNumeroDeCuenta();
    }
}
