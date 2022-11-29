package com.dh.clinica.demo.controllers.impl;

import com.dh.clinica.demo.exceptions.EntityNotFoundException;
import com.dh.clinica.demo.exceptions.IntegrityDataException;
import com.dh.clinica.demo.service.impl.PacienteService;
import com.dh.clinica.demo.model.PacienteDto;
import com.dh.clinica.demo.controllers.CRUDController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController implements CRUDController<PacienteDto> {

    @Qualifier("pacienteService")
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Override
    @ApiOperation(value = "Crea un nuevo paciente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 400, message = "Bad Request") })
    @PostMapping()
    public ResponseEntity<PacienteDto> registrar(@RequestBody PacienteDto paciente) throws IntegrityDataException, EntityNotFoundException {
        PacienteDto pacienteInsertado = pacienteService.crear(paciente);
        return ResponseEntity.ok(pacienteInsertado);
    }

    @Override
    @ApiOperation(value = "Busca un paciente por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request") })
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) throws IntegrityDataException, EntityNotFoundException {
        PacienteDto paciente = pacienteService.buscarPorId(id);
        return ResponseEntity.ok(paciente);
    }

    @GetMapping(params = "dni")
    @ApiOperation(value = "Busca un paciente por DNI")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request") })
    public ResponseEntity<PacienteDto> buscar(@RequestParam Integer dni) throws IntegrityDataException, EntityNotFoundException {
        PacienteDto paciente = pacienteService.buscar(dni);
        return ResponseEntity.ok(paciente);
    }

    @ApiOperation(value = "Busca pacientes por nombre")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 400, message = "Bad Request") })
    @GetMapping(params = "nombre")
    public ResponseEntity<List<PacienteDto>> buscar(@RequestParam String nombre) {
        List<PacienteDto> pacientes = pacienteService.buscar(nombre);
        return ResponseEntity.ok(pacientes);
    }

    @ApiOperation(value = "Busca pacientes por nombre y apellido")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 400, message = "Bad Request") })
    @GetMapping(params = {"nombre", "apellido"})
    public ResponseEntity<List<PacienteDto>> buscar(@RequestParam String nombre, @RequestParam String apellido) {
        List<PacienteDto> pacientes = pacienteService.buscar(nombre, apellido);
        return ResponseEntity.ok(pacientes);
    }

    @Override
    @ApiOperation(value = "Actualiza un paciente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request") })
    @PutMapping()
    public ResponseEntity<?> actualizar(@RequestBody PacienteDto paciente) throws IntegrityDataException, EntityNotFoundException {
        PacienteDto actualizado = pacienteService.actualizar(paciente);
        return ResponseEntity.ok(actualizado);
    }

    @Override
    @ApiOperation(value = "Elimina un paciente")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request") })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) throws IntegrityDataException, EntityNotFoundException {
        pacienteService.eliminar(Integer.parseInt(id));
        return ResponseEntity.ok("Se eliminó el paciente con id " + id);
    }

    @Override
    @ApiOperation(value = "Busca todos los pacientes")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request") })
    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscarTodos() {
        return ResponseEntity.ok(pacienteService.consultarTodos());
    }
}
