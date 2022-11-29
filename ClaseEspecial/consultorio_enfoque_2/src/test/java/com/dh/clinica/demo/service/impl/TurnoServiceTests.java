package com.dh.clinica.demo.service.impl;

import com.dh.clinica.demo.model.DomicilioDto;
import com.dh.clinica.demo.model.OdontologoDto;
import com.dh.clinica.demo.model.PacienteDto;
import com.dh.clinica.demo.model.TurnoDto;
import com.dh.clinica.demo.exceptions.IntegrityDataException;
import com.dh.clinica.demo.exceptions.EntityNotFoundException;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class TurnoServiceTests {

    @Autowired
    private PacienteService pacienteService;
    private PacienteDto paciente;

    @Autowired
    private OdontologoService odontologoService;
    private OdontologoDto odontologo;

    @Autowired
    private TurnoService turnoService;

    @BeforeEach
    public void setUp() {
        DomicilioDto domicilio = new DomicilioDto();
        domicilio.setCalle("Siempreviva");
        domicilio.setNumero(742);
        domicilio.setLocalidad("Springfield");
        domicilio.setProvincia("Springfield");

        paciente = new PacienteDto();
        paciente.setNombre("Homero");
        paciente.setApellido("Simpson");
        paciente.setDni(123456789);
        paciente.setDomicilio(domicilio);

        odontologo = new OdontologoDto();
        odontologo.setNombre("Pepo");
        odontologo.setApellido("Simpson");
        odontologo.setMatricula(123456);
    }

    @Test
    public void test01CrearTurnoConPacienteYOdontologoExistente() throws IntegrityDataException, EntityNotFoundException {
        PacienteDto pacienteCreado = pacienteService.crear(paciente);
        OdontologoDto odontologoCreado = odontologoService.crear(odontologo);
        TurnoDto turno = new TurnoDto();
        turno.setFecha(LocalDateTime.now());
        turno.setPaciente(pacienteCreado);
        turno.setOdontologo(odontologoCreado);
        TurnoDto turnoCreado = turnoService.crear(turno);
        assertNotNull(turnoService.buscarPorId(turnoCreado.getId()));
    }

    @Test
    public void test02CrearTurnoConPacienteYOdontologoInexistente() throws IntegrityDataException, EntityNotFoundException {
        PacienteDto pacienteCreado = pacienteService.crear(paciente);
        TurnoDto turno = new TurnoDto();
        turno.setFecha(LocalDateTime.now());
        turno.setPaciente(pacienteCreado);
        turno.setOdontologo(odontologo);
        assertThrows(IntegrityDataException.class, () -> turnoService.crear(turno));
    }

    @Test
    public void test04CrearTurnoConPacienteInexistenteOdontologoExistente() throws IntegrityDataException, EntityNotFoundException {
        OdontologoDto odontologoCreado = odontologoService.crear(odontologo);
        TurnoDto turno = new TurnoDto();
        turno.setFecha(LocalDateTime.now());
        turno.setPaciente(paciente);
        turno.setOdontologo(odontologoCreado);
        assertThrows(IntegrityDataException.class, () -> turnoService.crear(turno));
    }

    @Test
    public void test05CrearTurnoSinPacienteNiOdontologo() {
        TurnoDto turno = new TurnoDto();
        turno.setFecha(LocalDateTime.now());
        assertThrows(IntegrityDataException.class, () -> turnoService.crear(turno));
    }

    @Test
    public void test06NoSePuedeCrearTurnoConHorarioRepetidoParaOdontologo() throws IntegrityDataException, EntityNotFoundException {
        PacienteDto pacienteCreado = pacienteService.crear(paciente);
        OdontologoDto odontologoCreado = odontologoService.crear(odontologo);
        TurnoDto turno = new TurnoDto();
        turno.setFecha(LocalDateTime.of(2021, 9, 20, 18, 30));
        turno.setPaciente(pacienteCreado);
        turno.setOdontologo(odontologoCreado);
        TurnoDto turnoCreado = turnoService.crear(turno);
        assertNotNull(turnoService.buscarPorId(turnoCreado.getId()));
        assertThrows(IntegrityDataException.class, () -> turnoService.crear(turno));
    }

    @Test
    public void test07ActualizarTurno() throws IntegrityDataException, EntityNotFoundException {
        TurnoDto turno = new TurnoDto();
        turno.setFecha(LocalDateTime.of(2021, 9, 20, 18, 30));
        turno.setPaciente(pacienteService.crear(paciente));
        turno.setOdontologo(odontologoService.crear(odontologo));
        TurnoDto turnoCreado = turnoService.crear(turno);
        turno.setId(turnoCreado.getId());
        turno.setFecha(LocalDateTime.of(2021, 9, 27, 18, 30));
        TurnoDto turnoActualizado = turnoService.actualizar(turno);
        assertNotEquals(turnoActualizado, turnoCreado);
    }

    @Test
    public void test08NoSePuedeActualizarTurnoSinId() throws IntegrityDataException, EntityNotFoundException {
        TurnoDto turno = new TurnoDto();
        turno.setFecha(LocalDateTime.of(2021, 9, 20, 18, 30));
        turno.setPaciente(pacienteService.crear(paciente));
        turno.setOdontologo(odontologoService.crear(odontologo));
        turnoService.crear(turno);
        turno.setFecha(LocalDateTime.of(2021, 9, 27, 18, 30));
        assertThrows(IntegrityDataException.class, () -> turnoService.actualizar(turno));
    }

    @Test
    public void test08NoSePuedeActualizarTurnoConIdInexistente() throws IntegrityDataException, EntityNotFoundException {
        TurnoDto turno = new TurnoDto();
        turno.setFecha(LocalDateTime.of(2021, 9, 20, 18, 30));
        turno.setPaciente(pacienteService.crear(paciente));
        turno.setOdontologo(odontologoService.crear(odontologo));
        turnoService.crear(turno);
        turno.setId(51);
        turno.setFecha(LocalDateTime.of(2021, 9, 27, 18, 30));
        assertThrows(EntityNotFoundException.class, () -> turnoService.actualizar(turno));
    }

    @Test
    public void test10NoSePuedeActualizarTurnoSinPaciente() throws IntegrityDataException, EntityNotFoundException {
        TurnoDto turno = new TurnoDto();
        turno.setFecha(LocalDateTime.of(2021, 9, 20, 18, 30));
        turno.setPaciente(pacienteService.crear(paciente));
        turno.setOdontologo(odontologoService.crear(odontologo));
        turnoService.crear(turno);
        turno.setPaciente(null);
        turno.setFecha(LocalDateTime.of(2021, 9, 27, 18, 30));
        assertThrows(IntegrityDataException.class, () -> turnoService.actualizar(turno));
    }

    @Test
    public void test11NoSePuedeActualizarTurnoSinOdontologo() throws IntegrityDataException, EntityNotFoundException {
        TurnoDto turno = new TurnoDto();
        turno.setFecha(LocalDateTime.of(2021, 9, 20, 18, 30));
        turno.setPaciente(pacienteService.crear(paciente));
        turno.setOdontologo(odontologoService.crear(odontologo));
        turnoService.crear(turno);
        turno.setOdontologo(null);
        turno.setFecha(LocalDateTime.of(2021, 9, 27, 18, 30));
        assertThrows(IntegrityDataException.class, () -> turnoService.actualizar(turno));
    }

    @Test
    public void test12EliminarTurno() throws IntegrityDataException, EntityNotFoundException {
        TurnoDto turno = new TurnoDto();
        turno.setFecha(LocalDateTime.of(2021, 9, 20, 18, 30));
        turno.setPaciente(pacienteService.crear(paciente));
        turno.setOdontologo(odontologoService.crear(odontologo));
        turnoService.crear(turno);
        turnoService.eliminar(1);
        assertThrows(EntityNotFoundException.class, () -> turnoService.buscarPorId(1));
    }

    @Test
    public void test13ConsultarTodos() throws IntegrityDataException, EntityNotFoundException {
        TurnoDto turno = new TurnoDto();
        turno.setFecha(LocalDateTime.of(2021, 9, 20, 18, 30));
        turno.setPaciente(pacienteService.crear(paciente));
        turno.setOdontologo(odontologoService.crear(odontologo));
        turnoService.crear(turno);
        assertNotEquals(0, turnoService.consultarTodos().size());
    }

    @Test
    public void test13ConsultarTodosPorNombreYApellidoOdontologo() throws IntegrityDataException, EntityNotFoundException {
        TurnoDto turno = new TurnoDto();
        turno.setFecha(LocalDateTime.of(2021, 9, 20, 18, 30));
        turno.setPaciente(pacienteService.crear(paciente));
        turno.setOdontologo(odontologoService.crear(odontologo));
        turnoService.crear(turno);
        assertNotEquals(0, turnoService.buscar(odontologo.getNombre(), odontologo.getApellido()).size());
    }

    @Test
    public void test14ConsultarTodosPorDniPacienteYMatriculaOdontologo() throws IntegrityDataException, EntityNotFoundException {
        TurnoDto turno = new TurnoDto();
        turno.setFecha(LocalDateTime.of(2021, 9, 20, 18, 30));
        turno.setPaciente(pacienteService.crear(paciente));
        turno.setOdontologo(odontologoService.crear(odontologo));
        turnoService.crear(turno);
        assertNotEquals(0, turnoService.buscar(odontologo.getMatricula(), paciente.getDni()).size());
    }
}
