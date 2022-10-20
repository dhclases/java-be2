package com.digitalhouse.vacunacion;

import com.digitalhouse.vacunacion.model.Persona;
import com.digitalhouse.vacunacion.registro.Registro;
import com.digitalhouse.vacunacion.registro.RegistroVacunaProxy;

import java.util.Date;

public class Aplicacion {

    public static void main(String[] args) {
        // Definir la persona
        Persona persona = new Persona(" Juan ","Perez","35242184","Pfizer",new Date(121,6,5));

        // Registro de Vacunacion a traves del proxy
        Registro registro= new RegistroVacunaProxy();
        registro.registrar(persona.datos());

    }
}
