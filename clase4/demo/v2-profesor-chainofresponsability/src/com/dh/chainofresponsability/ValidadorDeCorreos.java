package com.dh.chainofresponsability;


import com.dh.chainofresponsability.chain.*;
import com.dh.chainofresponsability.model.Correo;

public class ValidadorDeCorreos
{
    private ProcesadorCorreo procesadorEstadoInicial;
    private final String MENSAJE_SPAM = "!Ojo marcado como spam...";

    public ValidadorDeCorreos() {
        // Configuramos los eslabones de la cadena
        procesadorEstadoInicial = new ProcesadorCorreoComercial();

        // Instanciamos los eslabones
        ProcesadorCorreo soporte = new ProcesadorCorreoSoporte();
        ProcesadorCorreo gerencia = new ProcesadorCorreoGerencia();
        ProcesadorCorreo spam = new ProcesadorCorreoSpam();

        //Interconectar
        procesadorEstadoInicial.setSiguienteProcesador(soporte);
        soporte.setSiguienteProcesador(gerencia);
        gerencia.setSiguienteProcesador(spam);

    }

    public boolean comprobar(Correo email){
        boolean result = !MENSAJE_SPAM.equalsIgnoreCase(procesadorEstadoInicial.comprobar(email));
        System.out.printf("Procesando: %s No es Spam: %s \n ",email.getAsunto(), result );
        return result;
    }

}


