package com.dh.mascotas.controller;

import com.dh.mascotas.domain.Movimiento;
import com.dh.mascotas.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    @Autowired
    MovimientoService movimientoService;

    @PostMapping
    public ResponseEntity<String> guardar( @RequestBody  Movimiento m){
        ResponseEntity<String> response = null;
        if(movimientoService.save(m).isPresent()){
            response = ResponseEntity.ok("El movimiento fue registrado");
        }else{
            response = ResponseEntity.internalServerError().body("Ups Houston tenemos problemas");
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Movimiento>> listar(){
        return ResponseEntity.ok(movimientoService.listar());
    }

}
