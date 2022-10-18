package com.dh.liquidacionsueldo.main.model;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
     private String nombre;
     private String apellido;
     LocalDate edad;
     private String email;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getEdad() {
        return edad;
    }

    public void setEdad(LocalDate edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String calcularNombreCompleto() {
        return this.nombre + ", " + this.apellido;
    }

    public boolean esMayorDeEdad() {
        return Period.between(this.edad, LocalDate.of(2021, 9, 21)).getYears() > 18;
    }
}
