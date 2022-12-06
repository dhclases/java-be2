package com.dh.paqueteria.controller;

import com.dh.paqueteria.exceptions.BadRequestException;
import com.dh.paqueteria.model.Paquete;
import com.dh.paqueteria.service.PaqueteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paquetes")
public class PaqueteController {

    private PaqueteService paqueteService;

    public PaqueteController(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se encontro el paquete",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Paquete.class)) }),
    @ApiResponse(responseCode = "400", description = "Id inválido de paquete",
            content = @Content),
    @ApiResponse(responseCode = "404", description = "Paquete no es encontrado",
            content = @Content) })

    @PostMapping
    public Paquete registar(@RequestBody Paquete paquete) throws BadRequestException {
        return paqueteService.agregar(paquete);
    }
    @Operation(summary = "Listar Paquetes")
    @GetMapping
    public List<Paquete> listar() {
        return paqueteService.listar();
    }

    @Operation(summary = "Paquetes en camino")
    @GetMapping("/en-camino")
    public List<Paquete> enCamino() {
        return paqueteService.paquetesEnCamino();
    }

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> procesarErrorBadRequest(BadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
