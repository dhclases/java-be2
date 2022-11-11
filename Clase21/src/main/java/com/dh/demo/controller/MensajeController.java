package com.dh.demo.controller;


import com.dh.demo.dominio.Mensaje;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensajeController {

    @GetMapping("/api/v1/mensajes/")
    private Mensaje obtenerMensajeV1(){
        Mensaje msj = new Mensaje();
        msj.setTipo("Mi tipo");
        msj.setMensajes("Este es un mensaje de prueba");
        return msj;
    }

    @GetMapping("/api/v2/mensajes/")
    private Mensaje obtenerMensajeV2(){
        return Mensaje.builder()
                .tipo("Tipo 2")
                .mensajes("Mensaje 2")
                .build();
    }
}
