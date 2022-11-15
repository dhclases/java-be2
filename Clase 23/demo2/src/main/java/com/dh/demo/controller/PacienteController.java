package com.dh.demo.controller;

import com.dh.demo.model.Paciente;
import com.dh.demo.services.PacienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/todos")
    public List<Paciente> getAll(){
        return pacienteService.getAll();
    }

    @GetMapping("/email")
    public Paciente getPacienteByEmail(@RequestParam(name="name", required = false, defaultValue = "asd") String email){
        Paciente paciente = pacienteService.getPacienteByEmail(email);
        return paciente;
    }

}
