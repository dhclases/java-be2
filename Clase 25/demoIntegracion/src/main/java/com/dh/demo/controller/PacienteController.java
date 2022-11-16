package com.dh.demo.controller;

import com.dh.demo.model.Paciente;
import com.dh.demo.repository.impl.PacienteRepositoryInMemory;
import com.dh.demo.services.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private PacienteService pacienteService = new PacienteService(new PacienteRepositoryInMemory());

    // URI Final: "/api/pacientes"
    @PostMapping()
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardar(paciente));
    }
    // URI Final: "/api/pacientes"
    @PutMapping()
    public ResponseEntity<Paciente> actualizarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.actualizar(paciente));
    }
    // URI Final: "/api/pacientes/{id}"
    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id){
        Paciente paciente = pacienteService.buscar(id);
        return ResponseEntity.ok(paciente);
    }
    // URI Final: "/api/pacientes"
    @GetMapping()
    public ResponseEntity<List<Paciente>> buscarTosos(){

        return ResponseEntity.ok(pacienteService.buscarTodos());
    }
    // URI Final: "/api/pacientes/{id}"
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id){
        ResponseEntity<String> response = null;
        // Validacion ejemplo
        if(pacienteService.buscar(id)!=null){
            pacienteService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Entidad Eliminada");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    }
