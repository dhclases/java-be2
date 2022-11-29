package com.dh.clinica.demo.controllers.impl;

import com.dh.clinica.demo.exceptions.EntityNotFoundException;
import com.dh.clinica.demo.exceptions.IntegrityDataException;
import com.dh.clinica.demo.service.impl.TurnoService;
import com.dh.clinica.demo.controllers.CRUDController;
import com.dh.clinica.demo.model.TurnoDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController implements CRUDController<TurnoDto> {

    @Qualifier("turnoService")
    private final TurnoService turnoService;

    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @Override
    @ApiOperation(value = "Crea un nuevo turno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 400, message = "Bad Request") })
    @PostMapping()
    public ResponseEntity<?> registrar(@RequestBody TurnoDto turno) throws IntegrityDataException, EntityNotFoundException {
        TurnoDto turnoInsertado = turnoService.crear(turno);
        return ResponseEntity.ok(turnoInsertado);
    }

    @Override
    @ApiOperation(value = "Busca un turno por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request") })
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) throws IntegrityDataException, EntityNotFoundException {
        TurnoDto turno = turnoService.buscarPorId(id);
        return ResponseEntity.ok(turno);
    }

    @ApiOperation(value = "Busca todos los turnos por nombre y apellido de paciente y odontólogo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request") })
    @GetMapping(params = {"nombrePaciente", "apellidoPaciente", "nombreOdontologo", "apellidoOdontologo"})
    public ResponseEntity<List<TurnoDto>> buscar(String nombrePaciente, String apellidoPaciente, String nombreOdontologo, String apellidoOdontologo) {
        List<TurnoDto> turnos = turnoService.buscar(nombrePaciente, apellidoPaciente, nombreOdontologo, apellidoOdontologo);
        return ResponseEntity.ok(turnos);
    }


    @ApiOperation(value = "Busca todos los turnos por nombre y apellido de odontólogo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request") })
    @GetMapping(params = {"nombreOdontologo", "apellidoOdontologo"})
    public ResponseEntity<List<TurnoDto>> buscar(String nombreOdontologo, String apellidoOdontologo) {
        List<TurnoDto> turnos = turnoService.buscar(nombreOdontologo, apellidoOdontologo);
        return ResponseEntity.ok(turnos);
    }

    @ApiOperation(value = "Busca todos los turnos por DNI del paciente y matrícula del odontólogo")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request") })
    @GetMapping(params = {"matricula", "dni"})
    public ResponseEntity<List<TurnoDto>> buscar(Integer matricula, Integer dni) {
        List<TurnoDto> turnos = turnoService.buscar(matricula, dni);
        return ResponseEntity.ok(turnos);
    }

    @Override
    @ApiOperation(value = "Actualiza un turno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request") })
    @PutMapping()
    public ResponseEntity<?> actualizar(@RequestBody TurnoDto turno) throws IntegrityDataException, EntityNotFoundException {
        TurnoDto actualizado = turnoService.actualizar(turno);
        return ResponseEntity.ok(actualizado);
    }

    @Override
    @ApiOperation(value = "Elimina un turno")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success | OK"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 400, message = "Bad Request") })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) throws IntegrityDataException, EntityNotFoundException {
        turnoService.eliminar(Integer.parseInt(id));
        return ResponseEntity.ok("Se elimino el turno con id " + id);
    }

    @Override
    @ApiOperation(value = "Busca todos los turnos")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request") })
    @GetMapping
    public ResponseEntity<List<TurnoDto>> buscarTodos() {
        return ResponseEntity.ok(turnoService.consultarTodos());
    }


    @ApiOperation(value = "Busca todos los turnos de la próxima semana")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Bad Request") })
    @GetMapping("/proximos")
    public ResponseEntity<List<TurnoDto>> buscarTurnosDesde(
                                        @RequestParam(value = "dd") Integer dia,
                                        @RequestParam(value = "mm") Integer mes,
                                        @RequestParam(value = "yyyy") Integer anio,
                                        @RequestParam(value = "hh", defaultValue = "0") Integer hora,
                                        @RequestParam(value = "ss", defaultValue = "0") Integer minuto,
                                        @RequestParam(value = "cantDias", defaultValue = "7") Integer cantidadDias) {
        LocalDateTime desde = LocalDateTime.of(anio, mes, dia, hora, minuto);
        List<TurnoDto> turnos = turnoService.consultarProximosTurnos(desde, cantidadDias);
        return ResponseEntity.ok(turnos);
    }
}
