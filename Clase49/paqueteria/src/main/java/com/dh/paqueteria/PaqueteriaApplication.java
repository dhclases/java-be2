package com.dh.paqueteria;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Paquetes API",
        version = "2.0",
        description = "Información de Paquetes"))
public class PaqueteriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaqueteriaApplication.class, args);
    }

}
