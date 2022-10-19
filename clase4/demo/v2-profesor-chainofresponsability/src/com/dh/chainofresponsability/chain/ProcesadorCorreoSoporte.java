package com.dh.chainofresponsability.chain;

import com.dh.chainofresponsability.model.Correo;

public class ProcesadorCorreoSoporte  extends ProcesadorCorreo {


    public ProcesadorCorreoSoporte() {
        this.correoAsignado = "soporteIT@micolmena.com";
        this.asuntoporProcesar = "soporte";
    }

    @Override
    public String comprobar(Correo email) {
        String mensaje ="";

        if(this.esValidoElCorreo(email)){
            mensaje = "Enviando a Soporte";
        }else {
            if (this.getSiguienteProcesador() != null){
                mensaje = this.getSiguienteProcesador().comprobar(email);
            }
        }
        return mensaje;
    }

}
