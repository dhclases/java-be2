package com.dh.chainofresponsability.chain;


import com.dh.chainofresponsability.model.Correo;

public abstract class ProcesadorCorreo {


    protected String correoAsignado;
    protected String asuntoporProcesar;
    protected ProcesadorCorreo siguienteProcesador;

    // Metodo cumun para las implementqacion
    public abstract String comprobar(Correo elMail);

    public String getCorreoAsignado() {
        return correoAsignado;
    }

    public void setCorreoAsignado(String correoAsignado) {
        this.correoAsignado = correoAsignado;
    }

    public String getAsuntoporProcesar() {
        return asuntoporProcesar;
    }

    public void setAsuntoporProcesar(String asuntoporProcesar) {
        this.asuntoporProcesar = asuntoporProcesar;
    }

    public ProcesadorCorreo getSiguienteProcesador() {
        return siguienteProcesador;
    }

    public void setSiguienteProcesador(ProcesadorCorreo siguienteProcesador) {
        this.siguienteProcesador = siguienteProcesador;
    }

    protected boolean esValidoElCorreo(Correo email){
        return email.getDestino().equalsIgnoreCase(this.correoAsignado)
                || email.getAsunto().equalsIgnoreCase(this.asuntoporProcesar);
    }
}
