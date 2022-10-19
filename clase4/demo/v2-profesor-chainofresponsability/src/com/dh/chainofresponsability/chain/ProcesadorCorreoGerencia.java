package com.dh.chainofresponsability.chain;


import com.dh.chainofresponsability.model.Correo;

public class ProcesadorCorreoGerencia extends ProcesadorCorreo {


    public ProcesadorCorreoGerencia() {
        this.correoAsignado = "gerencia@micolmena.com";
        this.asuntoporProcesar = "gerencia";
    }

    @Override
    public String comprobar(Correo email) {
        String mensaje ="";

        if(this.esValidoElCorreo(email)){
            mensaje = "Enviando a Gerencia";
        }else {
            if (this.getSiguienteProcesador() != null){
                mensaje = this.getSiguienteProcesador().comprobar(email);
            }
        }
        return mensaje;
    }

}
