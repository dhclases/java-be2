package com.dh.demo.dominio.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MensajeDto {
    private String tipo;
    private String mensajes;
}
