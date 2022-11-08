package com.dh.demo.model;

public class Domicilio {
    private Integer idDomicilio;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;


    public Domicilio() {
    }

    public Domicilio(Integer idDomicilio, String calle, String numero, String localidad, String provincia) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio(Integer idDomicilio, String calle, String numero, String localidad, String provincia, Integer idPaciente) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

}
