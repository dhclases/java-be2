package com.dh.chainofresponsability;


import com.dh.chainofresponsability.model.Correo;

public class Main {

    public static void main(String[] args) {
            ValidadorDeCorreos proceso = new ValidadorDeCorreos();

            proceso.comprobar(new Correo("mio@gmail.com","soporte@gmail.com","reclamo"));
            proceso.comprobar(new Correo("mio@gmail.com","spd@ditial.com","gerencia"));
            proceso.comprobar(new Correo("mio@gmail.com","soporte3@gmail.com","comercial"));
            proceso.comprobar(new Correo("mio@gmail.com","soporte2@gmail.com","reclamo"));


    }

}

