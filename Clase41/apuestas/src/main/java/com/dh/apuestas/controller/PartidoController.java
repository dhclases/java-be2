package com.dh.apuestas.controller;

import com.dh.apuestas.exceptions.InvalidIDException;
import com.dh.apuestas.model.Partido;
import com.dh.apuestas.service.PartidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @PostMapping
    public Partido registrar(@RequestBody Partido partido) throws InvalidIDException {
        return partidoService.agregar(partido);
    }

    @GetMapping
    public List<Partido> listar(){
        return partidoService.listar();
    }
}
