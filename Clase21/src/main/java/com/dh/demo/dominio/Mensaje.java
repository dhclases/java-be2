package com.dh.demo.dominio;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Mensaje {
    private String tipo;
    private String mensajes;
}
