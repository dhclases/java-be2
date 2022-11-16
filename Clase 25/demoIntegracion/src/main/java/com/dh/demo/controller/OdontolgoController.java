package com.dh.demo.controller;

import com.dh.demo.model.Odontologo;

import com.dh.demo.repository.impl.OdontologRepositoryInMemory;
import com.dh.demo.services.OdontologService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/odontologos")
public class OdontolgoController {


    private OdontologService odontologService = new OdontologService(new OdontologRepositoryInMemory());
    
    // URI Final: "/api/odontologos"
    @PostMapping()
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologService.guardar(odontologo));
    }
    // URI Final: "/api/odontologos"
    @PutMapping()
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologService.actualizar(odontologo));
    }
    // URI Final: "/api/odontologos/{id}"
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Integer id){
        Odontologo odontologo = odontologService.buscar(id);
        return ResponseEntity.ok(odontologo);
    }
    // URI Final: "/api/odontologos"
    @GetMapping()
    public ResponseEntity<List<Odontologo>> buscarTosos(){

        return ResponseEntity.ok(odontologService.buscarTodos());
    }
    // URI Final: "/api/odontologos/{id}"
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        // Validacion ejemplo
        if(odontologService.buscar(id)!=null){
            odontologService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Entidad Eliminada");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }


}
